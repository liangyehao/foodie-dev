package com.liang.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/3/2 21:39
 * @content 最新商品VO
 */
@Data
public class NewItemsVO {

    private Integer rootCatId;
    private String rootCatName;
    private String slogan;
    private String catImage;
    private String bgColor;

    private List<SimpleItemVO> simpleItemList;
}
