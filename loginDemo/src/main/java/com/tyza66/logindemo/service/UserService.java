package com.tyza66.logindemo.service;

/**
 * Author: tyza66
 * Date: 2023/6/19 18:06
 * Github: https://github.com/tyza66
 **/

public interface UserService {
    //根据账号密码查询用户 用来登录 如果查询到了就返回true 没有就返回false
    public boolean login(String username, String password);

   //用户注册 成功返回true 失败返回false
    public boolean register(String username, String password);

    //修改用户角色 成功返回true 失败返回false
    public boolean updatePowerByUsername(String username, Integer power);
}
