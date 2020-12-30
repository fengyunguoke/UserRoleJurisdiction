package com.nari.controller;

import com.nari.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nari.pojo.Role;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class databaseController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询数据库 auth_manage 的数据,即使没有实体类也是可以的，用 Map，这个就先别删除了，理清头绪、思路、逻辑
    @GetMapping("/userList")
    public String roleList(){        //这样查询出的对象即是 object

        //接下来就是写原生的 sql 语句

        /*String sql3 = "insert into role(roleId, roleName,roleComment)values(120,'RRR','www')";
        jdbcTemplate.update(sql3);*/

        //查询多个对象
        String sql = "select * from role";
        RowMapper<Role> rowMapper = new BeanPropertyRowMapper<Role>(Role.class);
        List<Role> roles = new ArrayList<Role>();
        roles = jdbcTemplate.query(sql, rowMapper);
        System.out.println("多个对象==>" + roles);

        System.out.println("======================================");
        Iterator<Role> it = roles.iterator();
        while (it.hasNext()) {
            Role role = (Role) it.next();
            System.out.println("循环打印：" + role.getRoleId() + "  roleName:" + role.getRoleName() + "  comment:" + role.getRoleComment());
        }

        //单个对象
        /*RowMapper<Role> rowMapper2 = new BeanPropertyRowMapper<Role>(Role.class);
        Role role = jdbcTemplate.queryForObject(sql,rowMapper2);
        System.out.println("单个对象:  ID:" + role.getId() + "Name:" + role.getRoleName() + "Comment:" + role.getComment());
       */
        return "成功了";
    }

}
