package com.liang.service.impl;

import com.liang.enums.Sex;
import com.liang.mapper.UsersMapper;
import com.liang.pojo.Users;
import com.liang.pojo.bo.UserBO;
import com.liang.service.UserService;
import com.liang.utils.MD5Util;
import org.apache.commons.lang3.time.DateUtils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Date;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/2/25 21:52
 * @content 用户业务层实现类
 */
@Repository
public class UserServiceImpl implements UserService {

    /**
     * 默认用户头像
     */
    private static final String USER_FACE = "https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3840849326,1169383010&fm=111&gp=0.jpg";
    /**
     * 默认时间格式
     */
    private static final String DEFAULT_PATTERN = "yyyy-MM-dd";
    /**
     * 默认生日
     */
    private static final String DEFAULT_BIRTHDAY = "1970-01-01";

    /**
     * 用户访问数据库映射
     */
    @Autowired
    private UsersMapper usersMapper;

    /**
     * id生成工具
     */
    @Autowired
    private Sid sid;

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

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users createUser(UserBO userBo) {
        Users user = new Users();
        String id = sid.nextShort();
        user.setId(id);
        user.setUsername(userBo.getUsername());
        try {
            user.setPassword(MD5Util.getMD5Str(userBo.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //默认同用户名
        user.setNickname(user.getUsername());
        user.setFace(USER_FACE);
        try {
            user.setBirthday(DateUtils.parseDate(DEFAULT_BIRTHDAY,DEFAULT_PATTERN));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //默认保密
        user.setSex(Sex.secret.type);
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());
        usersMapper.insert(user);
        return user;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users queryUserForLogin(String username, String password) {

        Example userExample = new Example(Users.class);
        Example.Criteria userCriteria = userExample.createCriteria();
        userCriteria.andEqualTo("username",username);
        userCriteria.andEqualTo("password",password);

        return usersMapper.selectOneByExample(userExample);
    }


}
