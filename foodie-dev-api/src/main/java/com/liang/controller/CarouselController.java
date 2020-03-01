package com.liang.controller;

import com.liang.enums.YesOrNo;
import com.liang.pojo.Carousel;
import com.liang.service.CarouselService;
import com.liang.utils.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/2/28 23:15
 * @content 测试controller
 */
@Slf4j
@Api(value = "首页", tags = {"首页信息展示相关接口"})
@RestController
@RequestMapping("/index")
public class CarouselController {

    @Autowired
    private CarouselService carouselService;

    @ApiOperation(value = "查询所有轮播图",notes = "查询所有轮播图",httpMethod = "GET")
    @RequestMapping("/carousel")
    public ServerResponse findAllCarousel(){
        List<Carousel> carousels = carouselService.queryAll(YesOrNo.YES.type);
        return ServerResponse.ok(carousels);
    }

}
