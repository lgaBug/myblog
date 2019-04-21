package com.lga.myblog.controller.back;

import com.lga.myblog.bean.UserInfo;
import com.lga.myblog.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/back")
public class BackIndexController {

    private static final Logger LOG = LoggerFactory.getLogger(BackIndexController.class);

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/login")
    public String login(HttpSession session) {

        //退出登录后清除session
        session.invalidate();
        return "back/login";
    }

    @GetMapping("/index")
    public String index() {
        return "back/index";
    }

    @PostMapping("/login")
    public String loginIndex(UserInfo user, Model model, HttpSession session) {

        if (user.getUserAccount() == null || user.getUserAccount() == "") {
            new IllegalArgumentException("用户名为空");
        }
        if (user.getUserPassword() == null || user.getUserPassword() == "") {
            new IllegalArgumentException("密码为空");
        }

        UserInfo userInfo = userInfoService.login(user);
        if (userInfo != null) {
            //登录成功后,把当前用户存入到session
            session.setAttribute("userinfo", userInfo);
            return "back/index";
        } else {
            model.addAttribute("info", "账号或者密码错误");
            return "back/login";
        }

    }

    @RequestMapping("/main")
    public String main() {
        return "back/main";
    }

}
