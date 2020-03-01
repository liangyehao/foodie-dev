package com.liang.mapper;

import com.liang.my.mapper.MyMapper;
import com.liang.pojo.Category;
import com.liang.pojo.vo.CategoryVO;

import java.util.List;

/**
 * 自定义Mapper查询子分类
 * @author liangyehao
 */
public interface CategoryMapperCustom {
    List<CategoryVO> getSubCatList(Integer rootCatId);
}