package com.lga.myblog.service;

import com.lga.myblog.bean.MessageInfo;
import sun.plugin2.message.Message;

import java.util.List;

public interface MessageService {

    List<MessageInfo> getMessages(MessageInfo message);

    boolean deleteMessageById(Integer messageId);

    Boolean updateMessage(MessageInfo messageInfo);

    boolean saveMessage(MessageInfo messageInfo);

    Long getAllMessageCount();
}
