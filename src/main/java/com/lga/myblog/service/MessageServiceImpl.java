package com.lga.myblog.service;

import com.lga.myblog.bean.MessageInfo;
import com.lga.myblog.dao.MessageInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageInfoMapper messageInfoMapper;

    @Override
    public List<MessageInfo> getMessage(MessageInfo message) {
        return messageInfoMapper.getMessage(message);
    }

    @Override
    public boolean deleteMessageById(Integer messageId) {
        int flag = messageInfoMapper.deleteByPrimaryKey(messageId);
        return flag > 0 ? true : false;
    }

    @Override
    public Boolean updateMessage(MessageInfo messageInfo) {
        int flag = messageInfoMapper.updateByPrimaryKeySelective(messageInfo);
        return flag > 0 ? true : false;
    }
}
