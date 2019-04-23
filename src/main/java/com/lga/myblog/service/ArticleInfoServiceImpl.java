package com.lga.myblog.service;

import com.lga.myblog.bean.ArticleInfo;
import com.lga.myblog.dao.ArticleInfoMapper;
import com.sun.org.apache.bcel.internal.generic.I2F;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleInfoServiceImpl implements ArticleInfoService {

    @Autowired
    private ArticleInfoMapper articleInfoMapper;

    @Override
    public int deleteArticleByCategoryId(Integer categoryId) {
        int flag = articleInfoMapper.deleteArticleByCategoryId(categoryId);
        return flag;
    }

    @Override
    public List<ArticleInfo> getArticle(ArticleInfo articleInfo) {
        return articleInfoMapper.getArticle(articleInfo);
    }

    @Override
    public boolean saveArticle(ArticleInfo articleInfo) {
        if (articleInfo == null) {
            new IllegalArgumentException("添加文章失败，articleInfo对象为空");
        }
        int flag = articleInfoMapper.insertSelective(articleInfo);
        return flag > 0 ? true : false;
    }
}
