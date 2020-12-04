package com.myao.demo.controller;

import com.myao.demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping("/login")
    @ResponseBody
    public String  login(User user){
        System.out.println(user);
        return "登陆成功";
    }
}
