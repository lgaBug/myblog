package com.lga.myblog.controller.back;

import com.lga.myblog.bean.UserInfo;
import com.lga.myblog.service.UserInfoService;
import com.lga.myblog.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户管理的控制器
 */
@Controller
@RequestMapping("/back/user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;


    @RequestMapping("/list")
    public String userList(Model model, UserInfo user, Integer page) {
        PageBean<UserInfo> pageBean = userInfoService.getList(user, page);
        model.addAttribute("pageBean", pageBean);
        return "back/userinfo/userinfo_list";
    }





    @GetMapping("/add")
    public String addUserPage() {
        return "back/userinfo/userinfo_add";
    }



    @PostMapping("/add")
    public String addUser(UserInfo userInfo ,Model model) {
       /* int flag = userInfoMapper.insert(userInfo);
        model.addAttribute("flag", "");*/
        return "back/userinfo/userinfo_list";
    }
}
