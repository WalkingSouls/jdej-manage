package com.miquankj.api.utils;

import com.miquankj.api.entity.Product;

import java.util.Map;
import java.util.stream.Stream;

/**
 * 单元测试工具专用
 * @author liuyadong
 * @since 2019/5/7
 */
public class test {
    public static void main(String[] args) {
//        test();
        Product product = new Product();
        product.setStoreId(1);
        product.setProPic("1");
        try{
            Map<String, Object> map = MapUtil.entityToMap(product);
            System.out.println(map.size());
//            Stream<Map.Entry<String, Object>> stream = map.entrySet().stream();
//            stream.forEach(x-> System.out.println(x.getKey()));
//            stream.forEach(x-> System.out.println(x.getValue()));
        }catch (Exception e){
            e.printStackTrace();
        }
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
}
