package com.swjd.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.swjd.pojo.User;
import com.swjd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    //去到主界面
    @RequestMapping("/toLogin")
    public String toLogin(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "login";
    }

    //实现登录功能
    @RequestMapping("/doLogin")
    public String doLogin(User user, Model model, HttpSession session){
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("uname",user.getUname()).eq("password",user.getPassword());
        User u = userService.getOne(qw);
        if (u!=null){
            //账号密码正确
            if (u.getFlag().equals("1")){
                //可以登录成功的
                session.setAttribute("activeName",u.getUname());
                model.addAttribute("error",u.getUname());
                return "redirect:/cc/toMain";
            }else {
                //账号被冻结
                model.addAttribute("errorMsg","账户被冻结");
                model.addAttribute("user",user);
                return "login";
            }
        }else {
            //账号或密码不正确
            model.addAttribute("errorMsg","账号或密码不正确");
            model.addAttribute("user",user);
            return "login";
        }
    }

    //提供一个方法，能访问我的淘宝
    @RequestMapping("/toMyTb")
    public String toMyTb(){
        return "myTb";
    }

    //提供一个方法，能访问购物车
    @RequestMapping("/toCar")
    public String toCar(){
        return "shoppingCar";
    }

    //提供一个方法，能访问主界面
    @RequestMapping("/toMain")
    public String toMain(Model model){
        model.addAttribute("error","请登录");
        return "main";
    }

}
