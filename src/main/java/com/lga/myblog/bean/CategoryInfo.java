package com.lga.myblog.bean;

import java.io.Serializable;

public class CategoryInfo implements Serializable {

    private static final long serialVersionUID = -6416769911793183852L;

    private Integer categoryId;

    private String categoryName;

    private String categoryAlias;

    private String categoryDesc;

    private Integer number;


    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getCategoryAlias() {
        return categoryAlias;
    }

    public void setCategoryAlias(String categoryAlias) {
        this.categoryAlias = categoryAlias == null ? null : categoryAlias.trim();
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc == null ? null : categoryDesc.trim();
    }

    @Override
    public String toString() {
        return "CategoryInfo{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryAlias='" + categoryAlias + '\'' +
                ", categoryDesc='" + categoryDesc + '\'' +
                ", number=" + number +
                '}';
    }
}