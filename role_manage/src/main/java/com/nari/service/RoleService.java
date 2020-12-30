package com.nari.service;

import com.nari.dao.RoleDao;
import com.nari.mapper.RoleMapper;
import com.nari.pojo.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleDao roleDao;

    @Autowired
    RoleMapper roleMapper;

    //查询所有角色
    public List<Role> getAllRole(){
        List<Role> roles = new ArrayList<Role>();
        roles = roleMapper.getAllRole();
        return roles;
    }

    //添加角色
    public String addRole(Role role){
        //调用dao层的addRole
        int i = roleMapper.addRole(role);
        System.out.println(i);
        return "mapper ok!";
    }

}

