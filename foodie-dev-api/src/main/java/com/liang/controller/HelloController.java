package com.liang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/2/22 23:57
 * @content hello控制器
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public Object hello(){
        return "Hello World~";
    }
}
