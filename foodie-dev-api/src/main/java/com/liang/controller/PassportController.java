package com.liang.controller;

import com.liang.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/usernameIsExist")
    public HttpStatus usernameIsExist(@RequestParam String username){

        //1.判断用户名是否为空
        if (StringUtils.isBlank(username)) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

        //2.查找用户名是否存在
        Boolean isExist = userService.queryUserIsExist(username);
        if (isExist) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

        //3.请求成功，用户名没有重复
        return HttpStatus.OK;
    }
}
