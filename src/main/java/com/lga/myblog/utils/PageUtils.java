package com.lga.myblog.utils;

public class PageUtils {

    /**
     * 获取总页数
     * @param allRow 总记录数
     * @param pageSize 每页显示多少条记录
     * @return
     */
    public static int countTotalPage(int allRow, int pageSize) {

        return allRow % pageSize == 0 ? allRow / pageSize : allRow / pageSize + 1;
    }

    /**
     * 获取当前的页数
     * @param currentPage
     * @return
     */
    public static int currentPage(Integer currentPage) {
        if (currentPage == null) {
            currentPage = 0;
        }
        return currentPage == 0 ? 1 : currentPage;
    }

    /**
     * 计算起始记录数
     * @param pageSize
     * @param currentPage
     * @return
     */
    public static int countStart(int pageSize, int currentPage) {
        return pageSize * (currentPage - 1);
    }
}
