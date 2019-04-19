package com.lga.myblog.controller.back;

import com.lga.myblog.bean.ArticleInfo;
import com.lga.myblog.dao.ArticleInfoMapper;
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


    @GetMapping("/list")
    public String messageListPage() {
        return "back/message/message_list";
    }

    @GetMapping("/update")
    public String addMessagePage() {
        return "back/message/message_update";
    }

    @PostMapping("/add")
    public String addMessage(ArticleInfo articleInfo, Model model) {
        return "back/message/message_list";
    }
}
