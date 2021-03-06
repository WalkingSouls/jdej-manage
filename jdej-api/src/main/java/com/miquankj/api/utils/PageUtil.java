package com.miquankj.api.utils;

import com.miquankj.api.dto.Goodsdto;
import com.miquankj.api.dto.Productdto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuyadong
 * @since 2019/5/7
 */
public class PageUtil<T> {
    public Map<String,Object> objectPageToMap(int pageNum, int pageSize, int totalRecord, List<T> list){
        Map<String, Object> map = new HashMap<>();
        int totalPage = totalRecord%pageSize ==0 ? (totalRecord / pageSize):(totalRecord / pageSize +1);
        map.put("totalRecord",totalRecord);
        map.put("totalPage",totalPage);
        map.put("pageNum",pageNum);
        map.put("pageSize",pageSize);
        map.put("list",list);
        return map;
    }
    public static Map<String,Object> goodsPageToMap(int pageNum, int pageSize, int totalRecord, List<Goodsdto> goodsList){
        Map<String, Object> map = new HashMap<>();
        int totalPage = totalRecord%pageSize ==0 ? (totalRecord / pageSize):(totalRecord / pageSize +1);
        map.put("totalRecord",totalRecord);
        map.put("totalPage",totalPage);
        map.put("pageNum",pageNum);
        map.put("pageSize",pageSize);
        map.put("goodsList",goodsList);
        return map;
    }
}
