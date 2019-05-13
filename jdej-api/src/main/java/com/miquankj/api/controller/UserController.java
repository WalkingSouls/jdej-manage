package com.miquankj.api.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miquankj.api.dto.Userdto;
import com.miquankj.api.entity.Role;
import com.miquankj.api.entity.Store;
import com.miquankj.api.entity.User;
import com.miquankj.api.enums.ResultEnum;
import com.miquankj.api.service.RoleServcie;
import com.miquankj.api.service.StoreService;
import com.miquankj.api.service.UserService;
import com.miquankj.api.utils.MD5Util;
import com.miquankj.api.utils.ResultVOUtil;
import com.miquankj.api.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * 用户controller
 * @author liuyadong
 * @since 2019/5/11
 */
@Api(value = "用户controller", description = "用户的创建、验证登录、编辑、列表等操作")
@Slf4j
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RoleServcie roleServcie;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private StoreService storeService;

    @ApiOperation(value = "用户登录及验证")
    @ApiResponses({
            @ApiResponse(code = 24, message = "账号不存在"),
            @ApiResponse(code = 25, message = "密码错误"),
            @ApiResponse(code = 26, message = "账号状态异常，请联系店铺管理员"),
            @ApiResponse(code = 27, message = "密码输错次数超过3次，请明日再来或联系店铺管理员"),
            @ApiResponse(code = 28, message = "您的账号已在另一个地方登录，如果不是您本人操作，请联系店铺管理员修改密码"),
            @ApiResponse(code = 29, message = "角色状态异常"),
            @ApiResponse(code = 30, message = "角色不存在"),
            @ApiResponse(code = 11, message = "店铺状态异常"),

    })
    @GetMapping("/login")
    public ResultVO login(Userdto userdto, HttpServletResponse response, HttpServletRequest request) {
        User user = userService.findUser(userdto);
        System.out.println(user.toString());
        String encryptBASE64 = MD5Util.encryptBASE64(userdto.getPassword());
        String passInput = MD5Util.decryptBASE64(encryptBASE64);
        if (user == null) {
            log.error("【用户】 账号不存在，user={}", userdto);
            return ResultVOUtil.error(ResultEnum.USER_NOT_EXIST.getCode(), ResultEnum.USER_NOT_EXIST.getMsg());
        }
        try {
            if (user.getErrorPass() > 3) {
                log.error("【用户】 密码输错次数超过3次，请明日再来或联系店铺管理员，user={}", user);
                userService.changeUserStatus(user.getUserId(),new Byte("0"));
                return ResultVOUtil.error(ResultEnum.PASS_ERROR_MAX.getCode(), ResultEnum.PASS_ERROR_MAX.getMsg());
            }
            boolean validPassword = MD5Util.verifyPass(passInput,user.getPassword());
            if (!validPassword) {
                userService.changeErrorPass(user.getUserId());
                log.error("【用户】 密码错误，user={}", user);
                return ResultVOUtil.error(ResultEnum.USER_PASS_ERROR.getCode(), ResultEnum.USER_PASS_ERROR.getMsg());
            }
       } catch (Exception e) {
            log.error(e.toString());
            return ResultVOUtil.error(ResultEnum.USER_PASS_ERROR.getCode(), ResultEnum.USER_PASS_ERROR.getMsg());
        }

        if (user.getStatus() != 1) {
            log.error("【用户】 账号状态异常，请联系店铺管理员，user={}", user);
            return ResultVOUtil.error(ResultEnum.USER_STATUS_ERROR.getCode(), ResultEnum.USER_STATUS_ERROR.getMsg());
        }
        if (user.getIsLogin() == 1) {
            log.error("【用户】 您的账号已在另一个地方登录，如果不是您本人操作，请联系店铺管理员修改密码，user={}", user);
            return ResultVOUtil.error(ResultEnum.USER_LOGINED.getCode(), ResultEnum.USER_LOGINED.getMsg());
        }
        Role role = roleServcie.findRole(user.getRoleId());
        if(role == null){
            log.error("【用户】 角色不存在，role={}", role);
            return ResultVOUtil.error(ResultEnum.ROLE_NOT_EXIST.getCode(), ResultEnum.ROLE_NOT_EXIST.getMsg());
        }
        if(role.getStatus() != 1 ){
            log.error("【用户】 角色状态异常，role={}", role);
            return ResultVOUtil.error(ResultEnum.ROLE_STATUS_ERROR.getCode(), ResultEnum.ROLE_STATUS_ERROR.getMsg());

        }
        Store store = storeService.findOne(user.getStoreId());
        if(store == null || store.getStatus() != 1){
            log.error("【商铺】 店铺状态异常，role={}", role);
            return ResultVOUtil.error(ResultEnum.STORE_STATUS_ERROR.getCode(), ResultEnum.STORE_STATUS_ERROR.getMsg());

        }
        String token = DigestUtils.md5Hex("MER_TICKET" + System.currentTimeMillis() + userdto.getAccount());
        Cookie cookie = new Cookie("MER_TICKET", token);
        cookie.setPath("/");
        if (userdto.getRememberMe() == 1) {
            cookie.setMaxAge(3600 * 24 * 15);
        }
        String userJson = null;
        try {
            userJson = objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            log.error("【用户】 转换json出错，user={}", user);
        }
        redisTemplate.opsForHash().put(token, user.hashCode(), userJson);
        redisTemplate.expire(token, 3600, TimeUnit.DAYS.SECONDS);
        response.addCookie(cookie);
        userService.changeLogin(user.getUserId(),userdto.getAccount(),new Byte("1"),new Date());
        request.getSession().setAttribute("userLogin",userdto.getAccount());
        HashMap<String, Object> map = new HashMap<>();
        map.put("account",user.getAccount());
        map.put("storeId",user.getStoreId());
        map.put("storeName",user.getStoreName());
        map.put("permissions",role.getPermissions());
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set(map);
        return ResultVOUtil.success(map);
    }
    @ApiOperation(value = "用户登出")
    @GetMapping("/logout/{userId}")
    public ResultVO logout(@PathVariable Integer userId,  HttpServletRequest request, HttpServletResponse response){
//        Cookie[] cookies = request.getCookies();
//        String token = null;
//        if(cookies.length != 0 || cookies != null){
//            for (Cookie cookie : cookies) {
//                if("MER_TICKET".equals(cookie.getName())){
//                    token = cookie.getValue();
//                    break;
//                }
//            }
//        }
//        if(StringUtils.isEmpty(token)){
//            Cookie cookie = new Cookie("MER_TICKET", "");
//            cookie.setPath("/");
//            cookie.setMaxAge(0);
//        }
        String account = (String) request.getSession().getAttribute("userLogin");
        System.out.println(account);
        userService.changeLogin(userId, account, new Byte("0"), null);
        request.getSession().removeAttribute("userLogin");
        return ResultVOUtil.success();
    }

}
