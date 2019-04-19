package com.lga.myblog.controller.back;

import com.lga.myblog.bean.ArticleInfo;
import com.lga.myblog.dao.ArticleInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 文章管理控制器
 */
@Controller
@RequestMapping("/back/article")
public class ArticleController {

    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    @GetMapping("/list")
    public String articleListPage() {
        return "back/article/article_list";
    }

    @GetMapping("/add")
    public String addArticlePage() {
        return "back/article/article_add";
    }

    @PostMapping("/add")
    public String addArticle(ArticleInfo articleInfo, Model model) {
        List<ArticleInfo> allArticle = articleInfoMapper.findAllArticle();
        model.addAttribute("articles", allArticle);
        return "back/article/article_list";
    }
}
