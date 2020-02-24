package com.liang.service;

import com.liang.pojo.Stu;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/2/23 22:00
 * @content stu服务层接口
 */
public interface StuService {

    Stu getStuInfo(int id);

    void saveStu();

    void updateStu();

    void deleteStu(int id);

    void saveParent();

    void saveChildren();

}
