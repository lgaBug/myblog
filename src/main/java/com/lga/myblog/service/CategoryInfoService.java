package com.lga.myblog.service;

import com.lga.myblog.bean.CategoryInfo;

import java.util.List;

public interface CategoryInfoService {

   boolean saveCategory(CategoryInfo info);

    List<CategoryInfo> getAllCategory();

    CategoryInfo getCategory(Integer categoryId);

    Boolean updateCategory(CategoryInfo categoryInfo);


    /**
     * 根据栏目编号进行删除
     * 1：先删除对应的栏目编号下的文章信息
     * 2：再删除对应的栏目
     * @param categoryId
     * @return
     */
    boolean deleteCategory(Integer categoryId);
}
