package com.liang.service.impl;

import com.liang.service.StuService;
import com.liang.service.TestTransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *     REQUIRED：使用当前的事务，如果没有事务，则自己新建一个事务，子方法是必须要运行在一个事务中；
 *                  如果存在这个事务，则加入这个事务，成为一个整体
 *
 *     SUPPORTS：如果当前有事务，则使用事务；如果没有，则不使用
 *
 *     MANDATORY：
 *     REQUIRES_NEW：
 *     NOT_SUPPORTED(4),
 *     NEVER(5),
 *     NESTED(6);
 *
 * @author liangyehao
 * @version 1.0
 * @date 2020/2/24 21:03
 * @content 测试service实现类
 */
@Service
public class TestTransServiceImpl implements TestTransService {

    @Autowired
    private StuService stuService;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void testPropagation() {
        stuService.saveParent();
        stuService.saveChildren();
    }
}
