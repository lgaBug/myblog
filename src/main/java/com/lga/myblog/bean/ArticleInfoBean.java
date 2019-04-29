package com.lga.myblog.bean;

import com.lga.myblog.utils.BaseBean;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;
import java.util.Date;

/**
 * Document 默认加上这个注解后，默认的情况下这个实体中的所有属性都会被建立索引和分词
 * indexName 索引库的名称 ，建议以项目命名
 * type 类型 建议以实体命名
 */
@Document(indexName = "myblog", type = "ArticleInfoBean", shards = 1, replicas = 1, refreshInterval = "-1")
public class ArticleInfoBean {

    @Id
    private Integer articleId;

    @Field
    private String articleTitle;

    @Field
    private String articleContent;

    @Field
    private String articleImg;

    @Field
    private Date articleTime;

    @Field
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Date getArticleTime() {
        return articleTime;
    }

    public void setArticleTime(Date articleTime) {
        this.articleTime = articleTime;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getArticleImg() {
        return articleImg;
    }

    public void setArticleImg(String articleImg) {
        this.articleImg = articleImg;
    }
}