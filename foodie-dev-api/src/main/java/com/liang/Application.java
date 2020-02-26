package com.liang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/2/22 23:56
 * @content 启动类
 */

@SpringBootApplication
@MapperScan(basePackages = "com.liang.mapper")
@ComponentScan(basePackages = {"com.liang","org.n3r.idworker"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
