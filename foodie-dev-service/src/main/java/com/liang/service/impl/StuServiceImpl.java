package com.liang.service.impl;

import com.liang.mapper.StuMapper;
import com.liang.pojo.Stu;
import com.liang.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/2/23 22:07
 * @content stu业务层实现类
 */
@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuMapper stuMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Stu getStuInfo(int id) {
        return stuMapper.selectByPrimaryKey(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveStu() {
        Stu stu = new Stu();
        stu.setName("wangdan");
        stu.setAge(20);
        stuMapper.insert(stu);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateStu() {
        Stu stu = new Stu();
        stu.setId(1);
        stu.setName("wangdan11111111");
        stu.setAge(20);
        stuMapper.updateByPrimaryKey(stu);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteStu(int id) {
        stuMapper.deleteByPrimaryKey(id);
    }


    @Override
    public void saveParent(){
        Stu stu = new Stu();
        stu.setName("parent");
        stu.setAge(20);
        stuMapper.insert(stu);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveChildren(){
        saveChildren1();
//        int a = 1/0;
        saveChildren2();
    }

    private void saveChildren1() {
        Stu stu = new Stu();
        stu.setName("child-1");
        stu.setAge(8);
        stuMapper.insert(stu);
    }

    private void saveChildren2() {
        Stu stu = new Stu();
        stu.setName("child-2");
        stu.setAge(6);
        stuMapper.insert(stu);
    }
}
