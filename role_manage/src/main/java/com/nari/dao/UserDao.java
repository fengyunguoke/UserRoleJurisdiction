package com.nari.dao;

import com.nari.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.*;

//模拟数据库
@Repository
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询所有用户
    public List<User> getAllUser(){
        String sql = "select * from user";

        //BeanPropertyRowMapper和JdbcTemplate 会将数据库的记录和实体类中的属性一一对应，要实现这种对应，则需要属性名和字段名遵守相应的规则
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        List<User> users = new ArrayList<User>();
        users = jdbcTemplate.query(sql, rowMapper);
        System.out.println("从数据库取出的多个User对象==>" + users);
        return users;                           //向 service 层返回 users 集合
    }

    //增加角色，数据库增
    public String addUser(User user){

        String sql = "insert into user(user_id, user_name, user_password, user_gender, status)values(?,?,?,?,?)";
        jdbcTemplate.update(sql, user.getUserId(), user.getUserName(), user.getUserPassword(),
                user.getUserGender(), user.getStatus());
        return "数据库插入成功！";
    }

    //根据 userId 删除用户
    public String deleteUser(int userId){

        String sql = "delete from user where user_id=?";
        String T = "数据库删除成功!";
        String F = "数据库删除失败!";
        try{
            jdbcTemplate.update(sql, userId);
        }catch (DataAccessException e){
            e.printStackTrace();
            return F;
        }
        return T;
    }
}