package com.liang.controller;

import com.liang.enums.YesOrNo;
import com.liang.pojo.Carousel;
import com.liang.pojo.Category;
import com.liang.pojo.vo.CategoryVO;
import com.liang.service.CarouselService;
import com.liang.service.CategoryService;
import com.liang.utils.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
public class IndexController {

    @Autowired
    private CarouselService carouselService;

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "查询所有轮播图",notes = "查询所有轮播图",httpMethod = "GET")
    @RequestMapping("/carousel")
    public ServerResponse findAllCarousel(){
        List<Carousel> carousels = carouselService.findAllCarousel(YesOrNo.YES.type);
        return ServerResponse.ok(carousels);
    }

    @ApiOperation(value = "查询商品分类（一级分类）",notes = "查询商品分类（一级分类）",httpMethod = "GET")
    @RequestMapping("/cats")
    public ServerResponse cats(){
        List<Category> categories = categoryService.queryAllRootLevelCat();
        return ServerResponse.ok(categories);
    }

    @ApiOperation(value = "查询商品子分类",notes = "查询商品子分类",httpMethod = "GET")
    @RequestMapping("/subCat/{rootCatId}")
    public ServerResponse subCat(
            @ApiParam(name = "rootCatId",value = "一级分类id",defaultValue = "1",required = true)
            @PathVariable Integer rootCatId){
        if (rootCatId==null) {
            ServerResponse.errMsg("分类不存在");
        }
        List<CategoryVO> subCatList = categoryService.getSubCatList(rootCatId);
        return ServerResponse.ok(subCatList);
    }

}
