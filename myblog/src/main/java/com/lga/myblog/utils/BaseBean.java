package com.lga.myblog.utils;

import java.io.Serializable;

/**
 * 所有需要做分页查询的父类
 */
public class BaseBean implements Serializable {

    private static final long serialVersionUID = -1744937690657866549L;

    /**
     * 起始下标
     */
    private Integer start;

    /**
     * 查询的长度
     */
    private Integer length;

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
