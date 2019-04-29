package com.lga.myblog.service;

import com.lga.myblog.bean.MessageInfo;
import com.lga.myblog.dao.MessageInfoMapper;
import com.lga.myblog.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageInfoMapper messageInfoMapper;

    @Override
    public List<MessageInfo> getMessages(MessageInfo message) {
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

    @Override
    public boolean saveMessage(MessageInfo messageInfo) {
        if (messageInfo != null) {
            messageInfo.setMessageTime(new Date());
            messageInfo.setMessageMark(Const.MARK_NO);
        }
        int flag = messageInfoMapper.insertSelective(messageInfo);
        return flag > 0 ? true : false;
    }

    @Override
    public Long getAllMessageCount() {
        return messageInfoMapper.getAllMessageCount();
    }
}
