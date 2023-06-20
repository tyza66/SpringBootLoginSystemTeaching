package com.tyza66.logindemo.service.impl;

import com.tyza66.logindemo.mapper.UserMapper;
import com.tyza66.logindemo.pojo.User;
import com.tyza66.logindemo.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author: tyza66
 * Date: 2023/6/19 18:10
 * Github: https://github.com/tyza66
 **/

//将UserServiceImpl交给IOC容器管理
@Service
public class UserServiceImpl implements UserService {

    //将Mybatis生成的的UserMapper实现类对象注入进来
    @Resource
    UserMapper userMapper;

    @Override
    public boolean login(String username, String password) {
        User login = userMapper.login(username, password);
        if (login != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean register(String username, String password) {
        List<User> users = userMapper.selectUserByUsername(username);
        if(users.size()>=1){
            return false;
        }else{
            int i = userMapper.insertUser(username, password);
            if(i>=1){
                return true;
            }else{
                return false;
            }
        }
    }

    @Override
    public boolean updatePowerByUsername(String username, Integer power) {
        int i = userMapper.updatePowerByUsername(username, power);
        if(i>=1){
            return true;
        }else{
            return false;
        }
    }
}
