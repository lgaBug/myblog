package com.lga.myblog.controller.back;

import com.lga.myblog.bean.ArticleInfo;
import com.lga.myblog.bean.CategoryInfo;
import com.lga.myblog.dao.ArticleInfoMapper;
import com.lga.myblog.service.CategoryInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章管理控制器
 */
@Controller
@RequestMapping("/back/category")
public class CategoryController {


    private static final Logger LOG = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryInfoService categoryInfoService;

    @GetMapping("")
    public String categoryListPage(Model model) {
        List<CategoryInfo> categoryInfoList = categoryInfoService.getAllCategory();
        model.addAttribute("categoryInfoList", categoryInfoList);
        return "back/category/category";
    }

    @GetMapping("/update")
    public String updateCategoryPage( Integer  categoryId, Model model) {
        CategoryInfo categoryInfo = categoryInfoService.getCategory(categoryId);
        model.addAttribute("categoryInfo", categoryInfo);
        return "back/category/category_update";
    }

    @PutMapping("")
    public String updateCategory(CategoryInfo categoryInfo, Model model) {
        Boolean flag = categoryInfoService.updateCategory(categoryInfo);
        model.addAttribute("info", flag ? "更新栏目成功" : "更新栏目失败");
        model.addAttribute("categoryInfo", categoryInfo);
        return "back/category/category_update";
    }

    @PostMapping("")
    public String addCatrgory(CategoryInfo categoryInfo, Model model) {
        if (categoryInfo == null) {
            LOG.error("保存的cateogryInfo对象为空,无法保存");
        }
        boolean flag = categoryInfoService.saveCategory(categoryInfo);

        model.addAttribute("info", flag ? "添加栏目成功" : "添加栏目失败");
        return "back/category/category_info";
    }

    @GetMapping("/delete")
    public String deleteCategory(Integer categoryId, Model model) {

        boolean flag = categoryInfoService.deleteCategory(categoryId);
        model.addAttribute("info", flag ? "删除栏目成功" : "删除栏目失败");
        return "back/category/category_info";
    }

}
