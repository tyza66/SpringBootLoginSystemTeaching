package com.tyza66.logindemo.mapper;

import com.tyza66.logindemo.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author: tyza66
 * Date: 2023/6/19 17:21
 * Github: https://github.com/tyza66
 **/

public interface UserMapper {

    // 根据账号密码查询用户 用来登录 如果查询到了就返回一个user对象否则返回的是null
    @Select("select * from user where username=#{username} and password=#{password}")
    public User login(String username, String password);

    //根据用户名查询用户 用来检查用户名是否已经存在
    @Select("select * from user where username=#{username}")
    public List<User> selectUserByUsername(String username);

    //向表中插入一条数据 用来注册
    @Insert("insert into user(username,password) values(#{username},#{password})")
    @Transactional
    public int insertUser(String username, String password);

    //通过用户名修改power 用于修改角色或权限
    @Update("update user set power=#{power} where username=#{username}")
    @Transactional
    public int updatePowerByUsername(String username, Integer power);
}
