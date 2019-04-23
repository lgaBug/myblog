package com.lga.myblog.service;

import com.lga.myblog.bean.UserInfo;
import com.lga.myblog.dao.UserInfoMapper;
import com.lga.myblog.utils.Const;
import com.lga.myblog.utils.PageBean;
import com.lga.myblog.utils.PageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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


        return pageBean;
    }

    @Override
    public int saveUser(UserInfo userInfo) {
        if (userInfo == null) {
            LOG.info("添加的userInfo为空");
            new IllegalArgumentException("userInfo对象为空");
        }
        //设置用户的标识为有效标识（因为页面没有传user_mark参数，所以需要手动设置）
        userInfo.setUserMark(Const.MARK_YES);
        int flag = userInfoMapper.insertSelective(userInfo);
        return flag;
    }

    @Override
    public UserInfo getUserInfoById(Integer userId) {

        if (userId <= 0 || userId == null) {
            new IllegalArgumentException("userId参数非法");
        }

        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userId);
        return userInfo;
    }

    @Override
    public int updateUser(UserInfo userInfo) {
        if (userInfo == null) {
            new IllegalArgumentException("更新用户的时，userInfo为空！");
        }

        int flag = userInfoMapper.updateByPrimaryKeySelective(userInfo);
        return flag;
    }


    @Override
    public boolean deleteUserById(UserInfo userInfo) {
        //设置用户表示为 -1 删除
        userInfo.setUserMark(Const.MARK_NO);
        int flag = userInfoMapper.updateByPrimaryKeySelective(userInfo);
        return flag > 0 ? true : false;
    }

    @Override
    public UserInfo login(UserInfo userInfo) {
        UserInfo userInfoList =  userInfoMapper.userLogin(userInfo);
        return userInfoList;
    }

    @Override
    public int getCount() {
        return userInfoMapper.getCount();
    }
}
