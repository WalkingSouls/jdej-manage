package com.miquankj.api.service;

import com.miquankj.api.entity.Category;
import com.miquankj.api.entity.Store;

/**
 * @author liuyadong
 * @since 2019/5/6
 */
public interface CategoryService {
    Category findOne(Integer categoryId);
}
