package com.lga.myblog.dao;

import com.lga.myblog.bean.ArticleInfoBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ArticleInfoBeanRepository extends ElasticsearchRepository<ArticleInfoBean,Integer> {

    Page<ArticleInfoBean> findDistinctArticleInfoBeanByArticleTitleContainingOrArticleContentContaining(String articleTitle, String articleContent, Pageable page);

    List<ArticleInfoBean> findDistinctArticleInfoBeanByArticleContentContainingOrArticleTitleContaining(String articleTitle, String articleContent);


}