package com.lga.myblog.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/back")
public class IndexController {

    @RequestMapping("/login")
    public String login() {
        return "back/login";
    }

    @RequestMapping("/index")
    public String index() {
        return "back/index";
    }

    @RequestMapping("/main")
    public String main() {
        return "back/main";
    }

}
