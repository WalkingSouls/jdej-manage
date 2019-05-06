package com.miquankj.api.service.impl;

import com.miquankj.api.dao.CategoryMapper;
import com.miquankj.api.entity.Category;
import com.miquankj.api.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyadong
 * @since 2019/5/6
 */
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;


    @Override
    public Category findOne(Integer categoryId) {
        return categoryMapper.selectByPrimaryKey(categoryId);
    }
}
