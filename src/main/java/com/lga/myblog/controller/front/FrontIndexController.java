package com.lga.myblog.controller.front;

import com.lga.myblog.bean.ArticleInfo;
import com.lga.myblog.bean.ArticleInfoBean;
import com.lga.myblog.bean.CategoryInfo;
import com.lga.myblog.bean.MessageInfo;
import com.lga.myblog.dao.ArticleInfoBeanRepository;
import com.lga.myblog.service.ArticleInfoService;
import com.lga.myblog.service.CategoryInfoService;
import com.lga.myblog.service.MessageService;
import com.lga.myblog.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private MessageService messageService;

    @Autowired
    private ArticleInfoBeanRepository er;


    /**
     * 首页展示信息
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model) {


        //查询最新的10篇文章
        List<ArticleInfo> newArticleList = articleInfoService.getNewArticleList();
        model.addAttribute("newArticleList", newArticleList);
        //初始化栏目信息和推荐文章
        init(model);

        return "/front/index";
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


    /**
     * 展现文章的详情信息
     * @param articleInfo
     * @param model
     * @return
     */
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

    @RequestMapping("/article/serarch")
    public String searchArticle(String keyBoard, Model model) {


        //获取搜索到的文章
        List<ArticleInfoBean> articleInfoBeans = er.findDistinctArticleInfoBeanByArticleContentContainingOrArticleTitleContaining(keyBoard, keyBoard);
        model.addAttribute("newArticleList", articleInfoBeans);

        init(model);
        return "/front/index";
    }

    /**
     * 获取栏目信息
     * @param categoryInfo
     * @param model
     * @param page
     * @return
     */
    @RequestMapping("/category/list")
    public String categoryList(CategoryInfo categoryInfo, Model model,Integer page) {

        CategoryInfo category = categoryInfoService.getCategory(categoryInfo.getCategoryId());
        model.addAttribute("category", category);

        //获取本栏目的所有文章
        PageBean<ArticleInfo> pageBean =  articleInfoService.getArticlesInCategoryId(categoryInfo, page);
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
     * 获取留言信息
     *
     * @param model
     * @return
     */
    @RequestMapping("/message/list")
    public String messageList(Model model) {

        //获取所有审核通过的留言（mark=="1"）
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setMessageMark("1");
        List<MessageInfo> messageInfos = messageService.getMessages(messageInfo);
        model.addAttribute("messageInfos", messageInfos);

        //初始化所有栏目信息
        List<CategoryInfo> categoryInfoList = categoryInfoService.getAllCategory();
        model.addAttribute("categoryInfoList", categoryInfoList);
        return "/front/message";
    }

    /**
     * 保存留言
     * @param messageInfo
     * @param model
     * @return
     */
    @RequestMapping("/message/add")
    public String saveMessage(MessageInfo messageInfo,Model model) {

        boolean flag = messageService.saveMessage(messageInfo);
        model.addAttribute("info", flag ? "添加留言成功，请等待审核" : "添加留言失败");
        return "/front/message_info";
    }








}
