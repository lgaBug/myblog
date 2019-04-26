package com.lga.myblog.controller.front;

import com.lga.myblog.bean.ArticleInfo;
import com.lga.myblog.bean.CategoryInfo;
import com.lga.myblog.service.ArticleInfoService;
import com.lga.myblog.service.CategoryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 前台展示的控制器
 */
@Controller
@RequestMapping("/front")
public class FrontIndexController {

    @Autowired
    private CategoryInfoService categoryInfoService;

    @Autowired
    private ArticleInfoService articleInfoService;

    /**
     * 首页展示信息
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model) {

        List<CategoryInfo> categoryInfoList = categoryInfoService.getAllCategory();
        model.addAttribute("categoryInfoList", categoryInfoList);

        //查询最新的三篇文章
        List<ArticleInfo> newArticleList = articleInfoService.getNewArticleList();
        model.addAttribute("newArticleList", newArticleList);

        //查询推荐的文章
        List<ArticleInfo> recomArticleList = articleInfoService.getRecomArticleList();
        model.addAttribute("recomArticleList", recomArticleList);


        return "/front/index";
    }

    @RequestMapping("/listview")
    public String listView(ArticleInfo articleInfo, Model model) {

        ArticleInfo article = articleInfoService.getArticleById(articleInfo.getArticleId());
        model.addAttribute("article", article);

        return "/front/listview";
    }

}
