package com.lga.myblog.service;

import com.lga.myblog.bean.ArticleInfo;
import com.lga.myblog.bean.CategoryInfo;
import com.lga.myblog.dao.CategoryInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryInfoServiceImpl implements CategoryInfoService {

    @Autowired
    private CategoryInfoMapper categoryInfoMapper;

    @Autowired
    private ArticleInfoService articleInfoService;

    @Override
    @CacheEvict(cacheNames = "liu" ,allEntries = true)
    public boolean saveCategory(CategoryInfo categoryInfo) {

        int flag = categoryInfoMapper.insertSelective(categoryInfo);

        return flag>0 ? true :false;
    }

    @Override
    @Cacheable(cacheNames = "liu" )
    public List<CategoryInfo> getAllCategory() {

        return categoryInfoMapper.getAllCategory();
    }

    @Override
    /*
    @Cacheable(cacheNames = "liu" ,key = "#p0")
    */
    public CategoryInfo getCategory(Integer categoryId) {
        if (categoryId == null || categoryId == 0) {
            new IllegalArgumentException("修改栏目失败，因为categoryId对象为空或者为0");
        }

        return categoryInfoMapper.selectByPrimaryKey(categoryId);
    }

    @Override
    @CacheEvict(cacheNames = "liu" ,allEntries = true)
    public Boolean updateCategory(CategoryInfo categoryInfo) {
        if (categoryInfo == null) {
            new IllegalArgumentException("更新栏目失败，因为categoryInfo对象为空");
        }
        return categoryInfoMapper.updateByPrimaryKeySelective(categoryInfo) > 0 ? true : false;
    }

    @Override
    @Transactional
    @CacheEvict(cacheNames = "liu" ,allEntries = true)
    public boolean deleteCategory(Integer categoryId) {

        if (categoryId <= 0) {
            new IllegalArgumentException("删除对应的栏目失败，因为categoryId小于等于0");
        }
        try {
            //删除文章
            articleInfoService.deleteArticleByCategoryId(categoryId);
            //删除栏目
            categoryInfoMapper.deleteByPrimaryKey(categoryId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
