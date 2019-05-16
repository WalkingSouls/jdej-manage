package com.miquankj.api.service;

import com.miquankj.api.dto.Userdto;
import com.miquankj.api.entity.User;

import java.util.Date;

/**
 * @author liuyadong
 * @since 2019/5/11
 */
public interface UserService {
    User findUser(Userdto userdto);

    Integer changeErrorPass(Integer userId);

    Integer changeUserStatus(Integer userId, Byte opertionType);

    Integer changeLogin(Integer userId, String account, Byte isLogined, Date loginTime);

    int resetErrorPass(Integer userId);
}
