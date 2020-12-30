package com.nari.service;

import com.nari.dao.UserDao;
import com.nari.dao.UserRoleDao;
import com.nari.mapper.UserMapper;
import com.nari.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    UserMapper userMapper;

    //查询所有用户
    public List<User> getAllUser(){

        List<User> users = new ArrayList<User>();
        users = userMapper.getAllUser();
        return users;
    }

    //增加用户
    public String addUser(User user){
        userMapper.addUser(user);
        return "成功";
    }

    //根据 userId 删除用户
    public String deleteUser(int userId){
        String deleteResult = null;
        userMapper.deleteUser(userId);
        return "删除成功";
    }

}
