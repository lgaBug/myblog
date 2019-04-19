package com.lga.myblog.service;

import com.lga.myblog.bean.UserInfo;
import com.lga.myblog.utils.PageBean;

import java.util.List;

public interface UserInfoService {

    public PageBean<UserInfo> getList(UserInfo user, Integer page);
}
