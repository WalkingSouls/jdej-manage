package com.miquankj.api.utils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.TreeMap;

/**
 * 生成map
 *
 * @author liuyadong
 * @since 2019/5/7
 */
public class MapUtil {
    /**
     * 将传入的参数按顺序封装到map中,限基本数据类型和其封装类
     *
     * @param object
     * @return
     */
    public static Map<String, Object> generateMap(Object... object) {
        Map<String, Object> map = new TreeMap<>();
        for (int i = 0; i < object.length; i++) {
            map.put("param" + i, object[i]);
        }
        return map;

    }

    /**
     * 将实体类按字段名称按顺序封装到map中
     *
     * @param object
     * @return
     */
    public static Map<String, Object> entityToMap(Object object) {
        Map<String, Object> map = new TreeMap<>();
        try {
            if (!isPrimitive(object)) {
                Field[] fields = object.getClass().getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    fields[i].setAccessible(true);
                    if (fields[i].get(object) == null) continue;
                    map.put(fields[i].getName(), fields[i].get(object));
                    System.out.println(fields[i].getName() + ":" + fields[i].get(object));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return map;
        }
    }

    /**
     * 判断是否是基本数据类型和其封装类
     *
     * @param obj
     * @return
     */
    public static boolean isPrimitive(Object obj) {
        try {
            return ((Class<?>) obj.getClass().getField("TYPE").get(null)).isPrimitive();
        } catch (Exception e) {
            return false;
        }
    }
}


