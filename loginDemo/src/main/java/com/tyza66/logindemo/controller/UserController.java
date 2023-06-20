package com.tyza66.logindemo.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.tyza66.logindemo.pojo.User;
import com.tyza66.logindemo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: tyza66
 * Date: 2023/6/20 8:13
 * Github: https://github.com/tyza66
 **/

@RestController
@RequestMapping("/user")
public class UserController {
    //注入Servcie层的对象
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        boolean login = userService.login(user.getUsername(), user.getPassword());
        if (login) {
            StpUtil.login(0);
            return "ok";
        } else {
            return "fail";
        }
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        boolean register = userService.register(user.getUsername(), user.getPassword());
        if (register) {
            return "ok";
        } else {
            return "fail";
        }
    }

    @PostMapping("/updatePower")
    public String updatePower(@RequestBody User user) {
        boolean login = StpUtil.isLogin();//判断是否登录了 登录了就返回true 没登陆就返回false
        if (login) {
            boolean updatePowerByUsername = userService.updatePowerByUsername(user.getUsername(), user.getPower());
            if (updatePowerByUsername) {
                return "ok";
            } else {
                return "fail";
            }
        } else {
            return "nologin";
        }
    }
}
