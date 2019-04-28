package com.lga.myblog.controller.front;

import com.lga.myblog.bean.ArticleInfo;
import com.lga.myblog.bean.CategoryInfo;
import com.lga.myblog.service.ArticleInfoService;
import com.lga.myblog.service.CategoryInfoService;
import com.lga.myblog.utils.Const;
import com.lga.myblog.utils.PageBean;
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


        //查询最新的三篇文章
        List<ArticleInfo> newArticleList = articleInfoService.getNewArticleList();
        model.addAttribute("newArticleList", newArticleList);
        init(model);

        return "/front/index";
    }


    @RequestMapping("/article/listview")
    public String listView(ArticleInfo articleInfo, Model model) {

        //对应的文章
        ArticleInfo article = articleInfoService.getArticleById(articleInfo.getArticleId());
        model.addAttribute("article", article);
        //对应的栏目
        CategoryInfo category = categoryInfoService.getCategory(article.getCategoryId());
        model.addAttribute("category", category);


        init(model);

        return "/front/listview";
    }

    @RequestMapping("/category/list")
    public String categoryList(CategoryInfo categoryInfo, Model model,Integer page) {

        CategoryInfo category = categoryInfoService.getCategory(categoryInfo.getCategoryId());
        //获取本栏目的所有文章
        PageBean<ArticleInfo> pageBean =  articleInfoService.getArticlesInCategoryId(categoryInfo, page);
        model.addAttribute("category", category);
        model.addAttribute("pageBean", pageBean);

        //获取本栏推荐
        List<ArticleInfo> recomArticleList = articleInfoService.getRecomArticleList(categoryInfo.getCategoryId());
        model.addAttribute("recomArticleList", recomArticleList);

        //初始化所有栏目信息
        List<CategoryInfo> categoryInfoList = categoryInfoService.getAllCategory();
        model.addAttribute("categoryInfoList", categoryInfoList);



        return "/front/list";
    }



    /**
     * 初始化推荐文章和栏目信息
     * @param model
     */
    private void init(Model model) {
        //查询推荐的文章
        List<ArticleInfo> recomArticleList = articleInfoService.getRecomArticleList(null);
        model.addAttribute("recomArticleList", recomArticleList);
        //初始化所有栏目信息
        List<CategoryInfo> categoryInfoList = categoryInfoService.getAllCategory();
        model.addAttribute("categoryInfoList", categoryInfoList);
    }

}
