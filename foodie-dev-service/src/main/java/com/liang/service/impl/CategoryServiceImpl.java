package com.liang.service.impl;

import com.liang.mapper.CategoryMapper;
import com.liang.mapper.CategoryMapperCustom;
import com.liang.pojo.Category;
import com.liang.pojo.vo.CategoryVO;
import com.liang.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/3/1 20:42
 * @content 分类菜单实现类
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryMapperCustom categoryMapperCustom;


    /**
     * 查询一级分类菜单
     *
     * @return 一级分类菜单
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Category> queryAllRootLevelCat() {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type",1);
        return categoryMapper.selectByExample(example);
    }

    /**
     * 根据一级分类id查询子分类信息
     *
     * @param rootCatId 一级分类id
     * @return 子分类信息
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<CategoryVO> getSubCatList(Integer rootCatId) {
        return categoryMapperCustom.getSubCatList(rootCatId);
    }
}
