package com.liang.pojo.vo;

import lombok.Data;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/3/1 22:39
 * @content 三级分类vo
 */
@Data
public class SubCategoryVO {
    private Integer subId;
    private String subName;
    private String subType;
    private String subFatherId;
}
