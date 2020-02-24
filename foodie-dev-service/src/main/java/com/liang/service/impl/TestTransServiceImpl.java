package com.liang.service.impl;

import com.liang.service.StuService;
import com.liang.service.TestTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/2/24 21:03
 * @content 测试service实现类
 */
@Service
public class TestTransServiceImpl implements TestTransService {

//    REQUIRED(0),
//    SUPPORTS(1),
//    MANDATORY(2),
//    REQUIRES_NEW(3),
//    NOT_SUPPORTED(4),
//    NEVER(5),
//    NESTED(6);

    @Autowired
    private StuService stuService;

//    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void testPropagation() {
        stuService.saveParent();

        stuService.saveChildren();
    }
}
