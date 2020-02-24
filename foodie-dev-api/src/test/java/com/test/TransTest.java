package com.test;

import com.liang.Application;
import com.liang.service.StuService;
import com.liang.service.TestTransService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/2/24 21:39
 * @content 测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TransTest {

    @Autowired
    private StuService stuService;

    @Autowired
    private TestTransService testTransService;

    @Test
    public void myTest(){
        testTransService.testPropagation();
    }
}
