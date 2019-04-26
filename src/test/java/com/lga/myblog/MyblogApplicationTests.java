package com.lga.myblog;

import com.lga.myblog.bean.MessageInfo;
import com.lga.myblog.dao.MessageInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyblogApplicationTests {

    @Autowired
    private MessageInfoMapper messageInfoMapper;


    @Test
    public void contextLoads() {
    }

    @Test
    public void test1() {

        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setMessageTime(new Date());

        this.messageInfoMapper.insert(messageInfo);


    }

    @Test
    public void test2() {
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setMessageId(4);
        System.out.println("messageInfoMapper.getMessage(messageInfo) = " + messageInfoMapper.getMessage(messageInfo));
    }


}
