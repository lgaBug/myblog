package com.lga.myblog.controller.back;

import com.lga.myblog.bean.UserInfo;
import com.lga.myblog.service.UserInfoService;
import com.lga.myblog.utils.Const;
import com.lga.myblog.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String addUser(UserInfo userInfo ,Model model,Integer page) {
        int flag = userInfoService.saveUser(userInfo);
        if (flag > 0) {
            model.addAttribute("info", "添加用户成功");
        } else {
            model.addAttribute("info", "添加用户失败");
        }
        return "back/userinfo/userinfo_add";
    }

    @GetMapping("/update")
    public String updatePage( Integer userId, Model model) {
        UserInfo userInfo = userInfoService.getUserInfoById(userId);
        model.addAttribute("userInfo", userInfo);
        return "back/userinfo/userinfo_update";
    }

    @PostMapping("/update")
    public String updateUser(UserInfo userInfo, Model model) {
        int flag = userInfoService.updateUser(userInfo);
        if (flag > 0) {
            model.addAttribute("info", "修改用户成功！");
        } else {
            model.addAttribute("info", "修改用户失败");
        }
        model.addAttribute("userInfo", userInfo);

        return "back/userinfo/userinfo_update";
    }

    @GetMapping("/delete")
    public String deleteUser(UserInfo userInfo) {
        userInfoService.deleteUserById(userInfo);
        return "redirect:/back/user/list?page=1";
    }
}
