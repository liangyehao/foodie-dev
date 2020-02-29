package com.liang.controller;

import com.alibaba.fastjson.JSONObject;
import com.liang.pojo.Users;
import com.liang.pojo.bo.UserBO;
import com.liang.service.UserService;
import com.liang.utils.CookieUtils;
import com.liang.utils.MD5Util;
import com.liang.utils.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.NoSuchAlgorithmException;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/2/25 22:26
 * @content 用户登录控制类
 */
@Slf4j
@Api(value = "注册登录", tags = {"用于注册登录的相关的接口"})
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
    @ApiOperation(value = "用户是否存在",notes = "用户是否存在",httpMethod = "GET")
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
    @ApiOperation(value = "用户注册",notes = "用户注册",httpMethod = "POST")
    @PostMapping("/regist")
    public ServerResponse regist(@RequestBody UserBO userBO,
                                HttpServletResponse response,
                                 HttpServletRequest request){
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
        Users userResult = userService.createUser(userBO);

        // 5.返回值设置私密信息为空
        setNullProperties(userResult);

        // 6.设置cookie存放用户信息
        CookieUtils.setCookie(request,response,"user", JSONObject.toJSONString(userResult),true);


        return ServerResponse.ok();
    }

    @ApiOperation(value = "用户登录",notes = "用户登录",httpMethod = "POST")
    @PostMapping("/login")
    public ServerResponse login(@RequestBody UserBO userBO,
                                HttpServletResponse response,
                                HttpServletRequest request) throws NoSuchAlgorithmException {
        String username = userBO.getUsername();
        String password = userBO.getPassword();

        // 0.判断用户名和密码不能为空
        if(StringUtils.isBlank(username)
                || StringUtils.isBlank(password)){
            return ServerResponse.errMsg("用户名和密码不能为空");
        }

        // 1.完成登录
        Users userResult = userService.queryUserForLogin(username, MD5Util.getMD5Str(password));
        if (userResult==null) {
            return ServerResponse.errMsg("用户名密码不正确");
        }

        // 2.返回值设置私密信息为空
        setNullProperties(userResult);

        // 3.设置cookie存放用户信息
        CookieUtils.setCookie(request,response,"user", JSONObject.toJSONString(userResult),true);

        return ServerResponse.ok(userResult);
    }

    @ApiOperation(value = "用户退出登录",notes = "用户退出登录",httpMethod = "POST")
    @PostMapping("/logout")
    public ServerResponse logout(@RequestParam String userId,
                                HttpServletResponse response,
                                HttpServletRequest request) {
        //清除用户相关cookie信息
        CookieUtils.deleteCookie(request,response,"user");
        log.info("======== 用户【{}】退出登录 ========",userId);

        // TODO 用户退出登录需要清空购物车
        // TODO 分布式会话中需要清除用户数据

        return ServerResponse.ok();
    }

    /**
     *  用户信息返回前端展示前，设置用户私密信息为空
     * @param userResult 用户信息
     */
    private void setNullProperties(Users userResult){
        userResult.setPassword(null);
        userResult.setMobile(null);
        userResult.setEmail(null);
        userResult.setCreatedTime(null);
        userResult.setUpdatedTime(null);
        userResult.setBirthday(null);
    }
}
