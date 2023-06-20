package com.tyza66.logindemo.controller;

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
    public String test1(){
        return "ok";
    }

    @GetMapping("/t2")
    public String test2(){
        return "ok";
    }

    @GetMapping("/t3")
    public String test3(){
        return "ok";
    }
}
