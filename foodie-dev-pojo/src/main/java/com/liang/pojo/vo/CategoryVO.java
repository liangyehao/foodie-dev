package com.liang.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/3/1 22:36
 * @content 二级分类vo
 */
@Data
public class CategoryVO {

    private Integer id;
    private String name;
    private String type;
    private String fatherId;

    /**
     * 三级分类vo
     */
    private List<SubCategoryVO> subCatList;
}
