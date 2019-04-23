package com.lga.myblog.controller.back;

import com.lga.myblog.bean.ArticleInfo;
import com.lga.myblog.bean.CategoryInfo;
import com.lga.myblog.bean.UserInfo;
import com.lga.myblog.service.ArticleInfoService;
import com.lga.myblog.service.CategoryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 文章管理控制器
 */
@Controller
@RequestMapping("/back/article")
public class ArticleController {

    @Autowired
    private ArticleInfoService articleInfoService;

    @Autowired
    private CategoryInfoService categoryInfoService;

    @RequestMapping("/list")
    public String articleListPage(ArticleInfo articleInfo ,Model model) {

        List<ArticleInfo> articles = articleInfoService.getArticle(articleInfo);
        model.addAttribute("articles", articles);
        return "back/article/article_list";
    }

    @GetMapping("/add")
    public String addArticlePage(Model model) {

        //查询出所有的栏目信息
        List<CategoryInfo> allCategory = categoryInfoService.getAllCategory();
        model.addAttribute("allCategory", allCategory);

        return "back/article/article_add";
    }

    @PostMapping("/add")
    public String addArticle(ArticleInfo articleInfo, Model model, HttpSession session) {

        //设置发布时间
        articleInfo.setArticleTime(new Date());
        //设置当前用户
        UserInfo userinfo = (UserInfo)session.getAttribute("userinfo");
        articleInfo.setUserId(userinfo.getUserId());
        //保存文章
        boolean flag = articleInfoService.saveArticle(articleInfo);
        model.addAttribute("info", flag ? "添加文章成功" : "添加文章失败");

        return "back/article/article_add";
    }
}
