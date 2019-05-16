package com.miquankj.api.service.impl;

import com.miquankj.api.dao.UserMapper;
import com.miquankj.api.dto.Userdto;
import com.miquankj.api.entity.User;
import com.miquankj.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 用户service
 * @author liuyadong
 * @since 2019/5/11
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User findUser(Userdto userdto) {
        User user = new User();
        user.setIsAdmin(null);
        user.setAccount(userdto.getAccount());
        User userDB = userMapper.selectByUser(user);
        return userDB;
    }

    @Override
    public Integer changeErrorPass(Integer userId) {
        return  userMapper.updateErrorPass(userId);
    }

    @Override
    public Integer changeUserStatus(Integer userId, Byte opertionType) {
        User user = new User();
        user.setIsAdmin(null);
        user.setUserId(userId);
        user.setStatus(opertionType);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Integer changeLogin(Integer userId, String account, Byte isLogined, Date loginTime) {
        User user = new User();
        user.setIsAdmin(null);
        user.setUserId(userId);
        user.setAccount(account);
        user.setLoginTime(loginTime);
        user.setIsLogin(isLogined);
        return  userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int resetErrorPass(Integer userId) {
        return  userMapper.resetErrorPass(userId);
    }
}
