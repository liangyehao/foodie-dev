package com.liang.mapper;

import com.liang.pojo.vo.CategoryVO;
import com.liang.pojo.vo.NewItemsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 自定义Mapper查询子分类
 * @author liangyehao
 */
public interface CategoryMapperCustom {
    List<CategoryVO> getSubCatList(Integer rootCatId);

    List<NewItemsVO> getSixNewItemsLazy(@Param("paramMap") Map<String,Object> map);
}