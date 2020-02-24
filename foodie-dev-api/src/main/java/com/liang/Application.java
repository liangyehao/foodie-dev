package com.liang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/2/22 23:56
 * @content 启动类
 */

@SpringBootApplication
@MapperScan(basePackages = "com.liang.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
