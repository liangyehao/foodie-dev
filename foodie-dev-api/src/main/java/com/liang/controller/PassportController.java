package com.liang.controller;

import com.liang.pojo.bo.UserBO;
import com.liang.service.UserService;
import com.liang.utils.ServerResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/2/25 22:26
 * @content 用户登录控制类
 */
@RestController
@RequestMapping("/passport")
public class PassportController {
    /**
     * 用户业务类
     */
    @Autowired
    private UserService userService;

    /**
     * 检查用户名是否已存在
     * @param username 用户名
     * @return 检查结果
     */
    @GetMapping("/usernameIsExist")
    public ServerResponse usernameIsExist(@RequestParam String username){

        //1.判断用户名是否为空
        if (StringUtils.isBlank(username)) {
            return ServerResponse.errMsg("用户名不能为空");
        }

        //2.查找用户名是否存在
        boolean isExist = userService.queryUserIsExist(username);
        if (isExist) {
            return ServerResponse.errMsg("用户名已存在");
        }

        //3.请求成功，用户名没有重复
        return ServerResponse.ok();
    }


    /**
     * 用户注册
     * @param userBO 用户信息
     * @return 注册结果
     */
    @PostMapping("/regist")
    public ServerResponse regist(@RequestBody UserBO userBO){
        String username = userBO.getUsername();
        String password = userBO.getPassword();
        String confirmPassword = userBO.getConfirmPassword();

        // 0.判断用户名和密码不能为空
        if(StringUtils.isBlank(username)
                || StringUtils.isBlank(password)
                || StringUtils.isBlank(confirmPassword)){
            return ServerResponse.errMsg("用户名和密码不能为空");
        }

        // 1.查询用户名是否存在
        boolean isExist = userService.queryUserIsExist(username);
        if (isExist) {
            return ServerResponse.errMsg("用户名已存在");
        }

        // 2.判断密码长度不能小于6
        int atLeastLength = 6;
        if (password.length()<atLeastLength) {
            return ServerResponse.errMsg("密码长度不能小于6");
        }

        // 3.判断两次密码是否一致
        if (!password.equals(confirmPassword)) {
            return ServerResponse.errMsg("密码不一致");
        }

        // 4.完成注册
        userService.createUser(userBO);

        return ServerResponse.ok();
    }
}
