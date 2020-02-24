package com.liang.pojo;

import javax.persistence.Id;

public class Stu {
    @Id
    private Integer id;

    private String name;

    private Integer age;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }
}