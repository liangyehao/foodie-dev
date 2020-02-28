package com.liang.service;

import com.liang.pojo.Users;
import com.liang.pojo.bo.UserBO;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/2/25 21:49
 * @content 用户业务层接口
 */
public interface UserService {

    /**
     * 根据用户名查询用户是否存在
     * @param username 用户名
     * @return 用户是否存在
     */
    Boolean queryUserIsExist(String username);

    /**
     * 创建用户
     * @param userBo 前端用户类
     * @return 创建后的用户
     */
    Users createUser(UserBO userBo);

    /**
     * 检索用户名和密码是否匹配，用于用户登录
     * @param username 用户名
     * @param password 密码
     * @return 匹配的用户
     */
    Users queryUserForLogin(String username,String password);
}
