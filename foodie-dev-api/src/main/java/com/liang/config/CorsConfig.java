package com.liang.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/2/28 21:53
 * @content 跨域配置
 */
@Configuration
public class CorsConfig {

    public CorsConfig() {
    }

    @Bean
    public CorsFilter corsFilter(){
        // 1.添加cors相关信息
        CorsConfiguration config = new CorsConfiguration();
        // 设置允许请求来源
        config.addAllowedOrigin("*");
        // 设置是否发送cookie
        config.setAllowCredentials(true);
        // 设置允许的请求方式
        config.addAllowedMethod("*");
        // 设置允许的header
        config.addAllowedHeader("*");

        // 2.为url添加请求路径
        UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
        corsSource.registerCorsConfiguration("/**",config);

        return new CorsFilter(corsSource);
    }
}
