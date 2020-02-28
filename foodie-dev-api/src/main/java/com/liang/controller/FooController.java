package com.liang.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/2/28 23:15
 * @content 测试controller
 */
@RestController
@RequestMapping("/foo")
public class FooController {

    @RequestMapping("/hello")
    public Object hello(){
        return "hello world!";
    }

    @RequestMapping("/setSession")
    public Object setSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("userInfo","new user");
        session.setMaxInactiveInterval(3600);
        session.getAttribute("userInfo");
//        session.removeAttribute("userInfo");
        return "ok";
    }
}
