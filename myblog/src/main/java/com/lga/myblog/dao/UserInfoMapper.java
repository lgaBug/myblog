package com.lga.myblog.dao;

import com.lga.myblog.bean.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    List<UserInfo> findAllUser();

    /**
     * 根据分页的条件查询用户的信息
     * @param userInfo
     * @return
     */
    List<UserInfo> getUserList(UserInfo userInfo);

    /**
     * 根据分页条件查询用户的数量
     * @param userInfo
     * @return
     */
    Long getUserCount(UserInfo userInfo);

}