package com.lga.myblog.dao;

import com.lga.myblog.bean.MessageInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageInfoMapper {
    int deleteByPrimaryKey(Integer messageId);

    int insert(MessageInfo record);

    int insertSelective(MessageInfo record);

    MessageInfo selectByPrimaryKey(Integer messageId);

    int updateByPrimaryKeySelective(MessageInfo record);

    int updateByPrimaryKey(MessageInfo record);
}