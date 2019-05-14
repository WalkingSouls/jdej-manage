package com.miquankj.api.utils;

import com.miquankj.api.dao.UserMapper;
import com.miquankj.api.entity.Product;
import com.miquankj.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 单元测试工具专用
 * @author liuyadong
 * @since 2019/5/7
 */
public class test {
    @Autowired
    private UserMapper userMapper;
    public static void main(String[] args) {
//        test();
//        Product product = new Product();
//        product.setStoreId(1);
//        product.setProPic("1");
//        try{
//            Map<String, Object> map = MapUtil.entityToMap(product);
//            System.out.println(map.size());
////            Stream<Map.Entry<String, Object>> stream = map.entrySet().stream();
////            stream.forEach(x-> System.out.println(x.getKey()));
////            stream.forEach(x-> System.out.println(x.getValue()));
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        String account = "zhangsan";
//        String password = "qwer9547QWER";
//        try{
//            String pwd = MD5Util.getEncryptedPwd(account + password);
//            System.out.println(pwd);
//            boolean validPassword = MD5Util.validPassword(account + password, pwd);
//            System.out.println(validPassword);
//        }catch (NoSuchAlgorithmException e){
//            e.printStackTrace();
//        }catch (UnsupportedEncodingException e){
//            e.printStackTrace();
//        }

        test3();
    }
    public static void test(){
        int a = 1;
        int b = 2;
        String c = "test";
        int d = 3;
        int e = 4;
        int f = 5;
        int g = 6;
        int h = 7;

        Map<String, Object> map = MapUtil.generateMap(a, b, c,d,e,f,g,h);
//        System.out.println(map.size());
        Stream<String> keySet = map.keySet().stream();
        Stream<Map.Entry<String, Object>> mapEntry = map.entrySet().stream();
        mapEntry.forEach(x-> System.out.println(x.getValue()));
        keySet.forEach(x-> System.out.println(x.toString()));
    }
    public static void test1(){
        String encrypt = MD5Util.encrypt("admin");
        System.out.println(encrypt);
    }
    public static void test2(){
        boolean verifyPass = MD5Util.verifyPass("zs789123ZS", "6365F82AF70FF4B6CBA7EB63112CD3DA");
        System.out.println(verifyPass);
    }
    public static void test3(){
        String today = TimeUtil.getToday();
        System.out.println(today);
        String nextDay = TimeUtil.getNextDay(today, "-3");
        System.out.println(nextDay);
    }
}
