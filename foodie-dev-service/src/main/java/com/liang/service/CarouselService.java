package com.liang.service;

import com.liang.pojo.Carousel;

import java.util.List;

/**
 * @author liangyehao
 * @version 1.0
 * @date 2020/3/1 15:41
 * @content 轮播图service
 */
public interface CarouselService {

    /**
     * 查询所有要展示的轮播图
     * @param isShow 是否展示
     * @return 轮播图集合
     */
    List<Carousel> findAllCarousel(Integer isShow);
}
