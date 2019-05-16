package com.miquankj.api.utils;

import com.miquankj.api.entity.User;

/**
 * 用户线程变量
 * @author liuyadong
 * @since 2019/5/16
 */
public class UserThreadLocal {
    private static ThreadLocal<User> userThread = new ThreadLocal<>();

    public static void  set(User user){
        userThread.set(user);
    }
    public static User  get(){
        return userThread.get();
    }
    public static void  remove(){
        userThread.remove();
    }
}
