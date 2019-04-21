package com.lga.myblog.service;

import com.lga.myblog.bean.UserInfo;
import com.lga.myblog.utils.PageBean;

import java.util.List;

public interface UserInfoService {

    public PageBean<UserInfo> getList(UserInfo user, Integer page);

    int saveUser(UserInfo userInfo);

    public UserInfo getUserInfoById(Integer userId);

    int updateUser(UserInfo userInfo);

    boolean deleteUserById(UserInfo userInfo);

    /**
     * 根据账号和密码查询用户信息
     * @param userInfo
     * @return
     */
    UserInfo login(UserInfo userInfo);
}
