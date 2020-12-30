package com.nari.dao;

import com.nari.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class RoleDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询所有角色
    public List<Role> getAllRole(){
        String sql = "select * from role";

        RowMapper<Role> rowMapper = new BeanPropertyRowMapper<Role>(Role.class);
        List<Role> roles = new ArrayList<Role>();
        roles = jdbcTemplate.query(sql, rowMapper);
        System.out.println("多个Role对象==>" + roles);
        return roles;                           //向 service 层返回 roles 集合
    }

    //增加角色
    public String addRole(Role role){
        /*System.out.println("这是dao 层的role" + role);
        String sql = "insert into role(role_id, role_name, role_comment)" +
                "values(118,'KKK','后台插入可以')";*/

        String sql = "insert into role(role_id, role_name, role_comment)values(?,?,?)";
        jdbcTemplate.update(sql,role.getRoleId(),role.getRoleName(),role.getRoleComment());
        return "数据库插入成功！";
    }
}
