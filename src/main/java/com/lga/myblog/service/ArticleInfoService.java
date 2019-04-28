package com.lga.myblog.service;

import com.lga.myblog.bean.ArticleInfo;
import com.lga.myblog.bean.CategoryInfo;
import com.lga.myblog.utils.PageBean;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArticleInfoService {

    /**
     * 根据栏目编号删除对应所有的文章信息
     * @param categoryId
     * @return
     */
    int deleteArticleByCategoryId(Integer categoryId);

    /**
     * 获取文章信息
     * @param articleInfo
     * @return
     */
    PageBean<ArticleInfo> getArticle(ArticleInfo articleInfo,Integer page);

    /**
     * 新增文章
     * @param articleInfo
     * @return
     */
    boolean saveArticle(ArticleInfo articleInfo);

    /**
     * 文件上传
     * @param file
     * @return
     */
    String doPutFile(MultipartFile file);

    /**
     * 通过articleId删除文章(将articleMark设置为'-1')
     * @param articleId
     * @return
     */
    boolean deleteArticleById(Integer articleId);

    ArticleInfo getArticleById(Integer articleId);

    boolean updateArticle(ArticleInfo articleInfo);

    List<ArticleInfo> getNewArticleList();

    List<ArticleInfo> getRecomArticleList(Integer categoryId);

    /**
     * 获取栏目categoryId 下的所有文章
     * @param categoryInfo
     * @return
     */
    PageBean<ArticleInfo> getArticlesInCategoryId(CategoryInfo categoryInfo,Integer page);
}
