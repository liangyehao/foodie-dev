package com.liang.service;

import com.liang.pojo.Category;

import java.util.List;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/3/1 20:39
 * @content 分类菜单service
 */
public interface CategoryService {

    /**
     * 查询一级分类菜单
     * @return 一级分类菜单
     */
    List<Category> queryAllRootLevelCat();
}
