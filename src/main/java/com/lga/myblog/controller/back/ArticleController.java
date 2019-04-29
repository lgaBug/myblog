package com.lga.myblog.controller.back;

import com.lga.myblog.bean.ArticleInfo;
import com.lga.myblog.bean.CategoryInfo;
import com.lga.myblog.bean.UserInfo;
import com.lga.myblog.service.ArticleInfoService;
import com.lga.myblog.service.CategoryInfoService;
import com.lga.myblog.utils.Const;
import com.lga.myblog.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String articleListPage(ArticleInfo articleInfo ,Model model,Integer page) {

        model.addAttribute("article", articleInfo);
        PageBean<ArticleInfo> pageBean = articleInfoService.getArticle(articleInfo == null ?new ArticleInfo():articleInfo, page);
        model.addAttribute("pageBean", pageBean);

        //查询出所有的栏目信息
        List<CategoryInfo> allCategory = categoryInfoService.getAllCategory();
        model.addAttribute("allCategory", allCategory);
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

        //查询出所有的栏目信息
        List<CategoryInfo> allCategory = categoryInfoService.getAllCategory();
        model.addAttribute("allCategory", allCategory);

        return "back/article/article_add";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam MultipartFile upload) {
        String url = articleInfoService.doPutFile(upload);

        return url;

    }

    /**
     * 在线文本编辑器上传的图片和文件
     * @param upload
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/uploadfile")
    @ResponseBody
    public void uploadFile(@RequestParam MultipartFile upload , HttpServletRequest request, HttpServletResponse response) {
        Map<Object, Object> map = new HashMap<>();
        try {
            String url = articleInfoService.doPutFile(upload);
            PrintWriter out = response.getWriter();

            response.setContentType("text/html;charset=UTF-8");
            String callback = request.getParameter("CKEditorFuncNum");
            out.println("<script>window.parent.CKEDITOR.tools.callFunction(" + callback + ",'" + url + "')</script>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/delete")
    public String deleteArticle(Integer articleId, Model model) {

        boolean flag = articleInfoService.deleteArticleById(articleId);
        model.addAttribute("info", flag ? "删除文章成功" : "删除文章失败");
        return "/back/article/article_info";
    }

    @GetMapping("/update")
    public String updateArticlePage(Integer articleId, Model model) {

        ArticleInfo articleInfo = articleInfoService.getArticleById(articleId);
        model.addAttribute("articleInfo", articleInfo);

        //查询出所有的栏目信息
        List<CategoryInfo> allCategory = categoryInfoService.getAllCategory();
        model.addAttribute("allCategory", allCategory);
        return "/back/article/article_update";
    }

    @PostMapping("/update")
    public String updateArticle(ArticleInfo articleInfo,Model model) {

        boolean flag = articleInfoService.updateArticle(articleInfo);
        model.addAttribute("info", flag ? "更新文章成功" : "更新文章失败");

        ArticleInfo articleInfo1 = articleInfoService.getArticleById(articleInfo.getArticleId());
        model.addAttribute("articleInfo", articleInfo1);

        //查询出所有的栏目信息
        List<CategoryInfo> allCategory = categoryInfoService.getAllCategory();
        model.addAttribute("allCategory", allCategory);




        return "/back/article/article_update";
    }

}
