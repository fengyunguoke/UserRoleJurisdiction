package com.nari.service;

import com.nari.dao.UserRoleDao;
import com.nari.mapper.UserRoleMapper;
import com.nari.pojo.Role;
import com.nari.pojo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserRoleService {

    @Autowired
    UserRoleDao userRoleDao;

    @Autowired
    UserRoleMapper userRoleMapper;


    //查询用户角色、菜单ID
    public int checkUserRole(int userId) {

        int checkResult = 0 ;

        checkResult =  userRoleMapper.checkUserRole(userId);
        System.out.println("取不到的 roleId 是什么==>" + checkResult);
        if (checkResult == 0) {
            System.out.println("返回值是0");
            System.out.println("此用户ID未被分配相应的角色，请以其它用户ID登陆！");

        }
        else if(checkResult == -1)
        {
            System.out.println("返回值是-1");
        }
        return checkResult;
    }

    //查询用户角色列表
    public List<UserRole> getAllUserRole() {
        List<UserRole> userRoles = new ArrayList<UserRole>();

        userRoles = userRoleMapper.getAllUserRole();
        return userRoles;
    }

    //根据用户id查询用户角色表,结果取到一个 UserRole 对象
    public UserRole getUserRoleById(int userId){
        UserRole userRole = userRoleMapper.getUserRoleById(userId);
        return userRole;
    }

    //添加用户角色
    public String addUserRole(UserRole userRole){
        //调用dao层的addUserRole
        userRoleMapper.addUserRole(userRole);
        return "mapper ok!";
    }
    
    //修改用户角色
    public int alterUserRole(UserRole userRole){
        int alterResult = 0;
        alterResult = userRoleMapper.alterUserRole(userRole);
        
        return alterResult;
    }
}




