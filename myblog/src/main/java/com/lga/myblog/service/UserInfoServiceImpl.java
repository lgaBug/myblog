package com.lga.myblog.service;

import com.lga.myblog.bean.UserInfo;
import com.lga.myblog.controller.back.IndexController;
import com.lga.myblog.dao.UserInfoMapper;
import com.lga.myblog.utils.Const;
import com.lga.myblog.utils.PageBean;
import com.lga.myblog.utils.PageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {


    private static final Logger LOG = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public PageBean<UserInfo> getList(UserInfo user, Integer page) {

        //获取总记录数
        Long allRow = userInfoMapper.getUserCount(user);
        //获取总页数
        Integer totalPage = (Integer) PageUtils.countTotalPage(allRow.intValue(), Const.PAGE_SIZE);
        //当前第几页
        int currentPage = PageUtils.currentPage(page);
        //起始记录数
        int start = PageUtils.countStart(Const.PAGE_SIZE, currentPage);

        if (page >= 0) {
            user.setStart(start);
            user.setLength(Const.PAGE_SIZE);
        } else {
            user.setStart(-1);
            user.setLength(-1);
        }

        List<UserInfo> userList = userInfoMapper.getUserList(user);

        //设置返回页面的pageBean详细信息
        PageBean<UserInfo> pageBean = new PageBean<>();
        pageBean.setList(userList);
        pageBean.setAllRow(allRow.intValue());
        pageBean.setCurrentPage(currentPage);
        pageBean.setTotalPage(totalPage);

        LOG.info("获取当前页数：{}",currentPage);

        return pageBean;
    }
}
