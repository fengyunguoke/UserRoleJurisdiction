package com.nari.dao;

import com.nari.pojo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRoleDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //根据 userid 从数据库查询相应的角色ID
    public int checkUserRole(int userId){

        String sql = "select role_id from user_role where user_id=?";

        //queryForObject 返回单行单列一个数据,当查不到 userid 时捕获空异常，并返回 null,
        int checkResult = 0;
        try{
            checkResult = jdbcTemplate.queryForObject(sql,new Object[] {userId}, java.lang.Integer.class);
            System.out.println("取得的roleId是==>" + checkResult);
        }catch (EmptyResultDataAccessException e){
            return checkResult ;
        }
        return checkResult;

    }

    //查询用户角色表
    public List<UserRole> getAllUserRole(){
        String sql = "select * from user_role";

        RowMapper<UserRole> rowMapper = new BeanPropertyRowMapper<UserRole>(UserRole.class);
        List<UserRole> userRoles = new ArrayList<UserRole>();
        userRoles = jdbcTemplate.query(sql, rowMapper);
        System.out.println("多个UserRole对象==>" + userRoles);
        return userRoles;                           //向 service 层返回 userRoles 集合
    }

    //新增UserRole对象
    public String addUserRole(UserRole userRole){
        String sql = "insert into user_role(user_id, role_id, user_role_id)values(?,?,?)";

        try{
            jdbcTemplate.update(sql, userRole.getUserId(), userRole.getRoleId(), userRole.getUserRoleId());
            return "数据库插入成功！";
        }catch(DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }

    //@RequestMapping("/GG")
    //根据 userId 查询用户角色表
    public UserRole getUserRoleById(int userId){

        String sql = "select * from user_role where user_id=?";

        RowMapper<UserRole> rowMapper = new BeanPropertyRowMapper<UserRole>(UserRole.class);
        UserRole userRole = null;
        userRole = jdbcTemplate.queryForObject(sql, rowMapper, userId);
        System.out.println("取出了一个 UserRole 对象==>" + userRole);
        return userRole;
    }

    //修改用户角色
    public String alterUserRole(UserRole userRole){

        String sql = "update user_role set role_id=?, user_role_id=? where user_id=?";
        String Y = "数据库插入成功!";
        String N = "数据库插入失败!";

        try{
            jdbcTemplate.update(sql, userRole.getRoleId(), userRole.getUserRoleId(), userRole.getUserId());
        }catch(DataAccessException e){
            e.printStackTrace();
            return N;
        }
        return Y;
    }

}

