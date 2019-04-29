package com.lga.myblog.controller.back;

import com.lga.myblog.bean.ArticleInfo;
import com.lga.myblog.bean.MessageInfo;
import com.lga.myblog.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 文章管理控制器
 */
@Controller
@RequestMapping("/back/message")
public class MessageController {

    private static final Logger LOG = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MessageService messageService;

    @RequestMapping("/list")
    public String messageListPage(MessageInfo message , Model model) {

        List<MessageInfo> messageInfos = messageService.getMessages(message);
        model.addAttribute("messageInfos", messageInfos);
        model.addAttribute("mess", message);

        return "back/message/message_list";
    }

    @GetMapping("/update")
    public String addMessagePage(MessageInfo messageInfo,Model model) {

        Boolean flag = messageService.updateMessage(messageInfo);
        /*
        model.addAttribute("info", flag ? "更新留言成功" : "更新留言失败");
        */
        LOG.info(flag ? "更新留言成功,留言记录的id为:{}" : "更新留言失败,留言记录的id为:{}",messageInfo.getMessageId());

        List<MessageInfo> messageInfos = messageService.getMessages(new MessageInfo());
        model.addAttribute("messageInfos", messageInfos);

        return "back/message/message_list";
    }

    @PostMapping("/add")
    public String addMessage(ArticleInfo articleInfo, Model model) {
        return "back/message/message_list";
    }

    @GetMapping("/delete")
    public String deleteMessage(Integer messageId,Model model) {
        boolean flag = messageService.deleteMessageById(messageId);
        model.addAttribute("info", flag ? "删除留言成功" : "删除留言失败");
        return "back/message/message_info";

    }
}
