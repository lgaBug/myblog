package com.lga.myblog.controller.back;

import com.lga.myblog.bean.UserInfo;
import com.lga.myblog.dao.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 用户管理的控制器
 */
@Controller
@RequestMapping("/back/user")
public class BackUserInfoController {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @GetMapping("/list")
    public String userList(Model model) {
        List<UserInfo> allUser = userInfoMapper.findAllUser();
        model.addAttribute("userList", allUser);
        return "back/userinfo/userinfo_list";
    }

    @GetMapping("/add")
    public String addUserPage() {
        return "back/userinfo/userinfo_add";
    }

    @PostMapping("/add")
    public String addUser(UserInfo userInfo ,Model model) {
        int flag = userInfoMapper.insert(userInfo);
        model.addAttribute("flag", "");
        return "back/userinfo/userinfo_list";
    }
}
