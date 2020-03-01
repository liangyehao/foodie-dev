package com.liang.enums;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/3/1 15:52
 * @content
 */
public enum YesOrNo {
    /**
     *
     */
    NO(0,"否"),YES(1,"是");

    public Integer type;
    public String value;

    YesOrNo(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
