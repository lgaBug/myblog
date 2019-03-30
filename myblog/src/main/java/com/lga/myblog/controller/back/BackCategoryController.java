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
@RequestMapping("/back/category")
public class BackCategoryController {


    @GetMapping("/list")
    public String articleListPage() {
        return "back/category/category";
    }

    @GetMapping("/update")
    public String updateCategoryPage() {
        return "back/category/category_update";
    }

    @PostMapping("/update")
    public String updateCategory(ArticleInfo articleInfo, Model model) {
        return "back/category/category";
    }
}
