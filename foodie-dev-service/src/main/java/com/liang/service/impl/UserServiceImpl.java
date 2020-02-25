package com.liang.service.impl;

import com.liang.mapper.UsersMapper;
import com.liang.pojo.Users;
import com.liang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/2/25 21:52
 * @content 用户业务层实现类
 */
@Repository
public class UserServiceImpl implements UserService {

    /**
     * 用户访问数据库映射
     */
    @Autowired
    private UsersMapper usersMapper;

    /**
     * 根据用户名查询用户是否存在
     * @param username 用户名
     * @return 用户是否存在
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Boolean queryUserIsExist(String username) {
        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("username",username);
        Users result = usersMapper.selectOneByExample(userExample);
        return result != null;
    }
}
