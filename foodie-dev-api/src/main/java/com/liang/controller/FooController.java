package com.liang.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/2/28 23:15
 * @content 测试controller
 */
@Slf4j
@RestController
@RequestMapping("/foo")
@ApiIgnore
public class FooController {

    @RequestMapping("/hello")
    public Object hello(){
        log.debug("debug::hello world!!!!!");
        log.info("info::hello world!!!!!");
        log.warn("warn::hello world!!!!!");
        log.error("error::hello world!!!!!");
        return "hello world!";
    }

    @RequestMapping("/setSession")
    public Object setSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("userInfo","new user");
        session.setMaxInactiveInterval(3600);
        session.getAttribute("userInfo");
        return "ok";
    }
}
