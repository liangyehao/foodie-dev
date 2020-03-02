package com.liang.service;

import com.liang.pojo.Category;
import com.liang.pojo.vo.CategoryVO;
import com.liang.pojo.vo.NewItemsVO;

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

    /**
     * 根据一级分类id查询子分类信息
     * @param rootCatId 一级分类id
     * @return 子分类信息
     */
    List<CategoryVO> getSubCatList(Integer rootCatId);


    /**
     * 懒加载最新的6个商品
     *
     * @param rootCatId 一级分类id
     * @return {@link List}
     */
    List<NewItemsVO> getSixNewItemsLazy(Integer rootCatId);
}
