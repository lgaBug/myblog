package com.lga.myblog.dao;

import com.lga.myblog.bean.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleInfoMapper {
    int deleteByPrimaryKey(Integer articleId);

    int insert(ArticleInfo record);

    int insertSelective(ArticleInfo record);

    ArticleInfo selectByPrimaryKey(Integer articleId);

    int updateByPrimaryKeySelective(ArticleInfo record);

    int updateByPrimaryKey(ArticleInfo record);

    List<ArticleInfo> findAllArticle();

    int deleteArticleByCategoryId(Integer categoryId);

    /**
     * 获取文章信息
     * @param articleInfo
     * @return
     */
    List<ArticleInfo> getArticle(ArticleInfo articleInfo);

    Long getArticleCount(ArticleInfo articleInfo);
}