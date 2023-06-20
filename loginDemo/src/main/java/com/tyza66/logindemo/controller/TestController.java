package com.tyza66.logindemo.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaCheckRole;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: tyza66
 * Date: 2023/6/20 8:20
 * Github: https://github.com/tyza66
 **/

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/t1")
    @SaCheckPermission("t1")//具有t1的权限才能调用
    public String test1(){
        return "ok";
    }

    @GetMapping("/t2")
    @SaCheckLogin //登陆了才能调用
    public String test2(){
        return "ok";
    }

    @GetMapping("/t3")
    @SaCheckRole("admin") //具有admin角色才能调用
    public String test3(){
        return "ok";
    }
}
