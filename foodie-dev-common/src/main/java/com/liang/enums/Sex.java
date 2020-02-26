package com.liang.enums;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/2/26 23:12
 * @content 姓别枚举类
 */
public enum Sex {

    man(1,"男"),
    woman(0,"女"),
    secret(2,"保密");

    /**
     * 类型
     */
    public final Integer type;
    /**
     * 值
     */
    public final String value;

    Sex(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
