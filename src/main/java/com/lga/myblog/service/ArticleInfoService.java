package com.lga.myblog.service;

import com.lga.myblog.bean.ArticleInfo;

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
    List<ArticleInfo> getArticle(ArticleInfo articleInfo);

    /**
     * 新增文章
     * @param articleInfo
     * @return
     */
    boolean saveArticle(ArticleInfo articleInfo);
}
