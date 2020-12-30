package com.nari;

import com.nari.pojo.Role;
import com.nari.pojo.User;
import com.nari.pojo.UserRole;
import com.nari.service.RoleService;
import com.nari.service.UserRoleService;
import com.nari.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//测试用例类
@SpringBootTest
class RoleManageApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    UserRoleService userRoleService;

    //数据源测试
    @Test
    void contextLoads() throws SQLException {
        //查看一下默认的数据源:class com.zaxxer.hikari.HikariDataSource
        System.out.println("dataSource class name==>" + dataSource.getClass());

        //获得数据库连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    //UserService 测试用例，敲代码 连数据库 写测试用例 学 VUE， 学前端， 学 Node.js 学 Jquery React
    @Test  //憧憬美好的事物都是哪些人哪些事从而让你处于一种满足的状态忘记过去 物来顺受 过往不恋 当时不杂 未来不迎
    void UserServiceTest(){
        //getAllUser() 测试用例
        List<User> users = new ArrayList<User>();
        users = userService.getAllUser();
        System.out.println("UserService.getAllUser() 测试用例==>" + users);

        //addUser() 测试用例
        userService.addUser(new User(1011, "测试", "123456", 1, "南京"));

        //deleteUser() 测试用例
        userService.deleteUser(1005);
    }

    //RoleService 测试用例
    @Test
    void RoleServiceTest(){
        //getAllRole() 测试用例
        List<Role> roles = new ArrayList<Role>();
        roles = roleService.getAllRole();
        System.out.println("UserService.getAllRole() 测试用例==>" + roles);

        //addRole() 测试用例
        roleService.addRole(new Role(111, "综合管理员", "综合管理权限"));
    }

    /*
    *    《沁园春 · 雪》
    *           --毛泽东
    * 北国风光，千里冰封，万里雪飘。
    * 望长城内外，惟余莽莽；大河上下 顿失滔滔。
    * 山舞银蛇，原驰蜡象，欲与天公试比高。
    * 须晴日，看红妆素裹，分外妖娆。
    *
    * 江山如此多娇，引无数英雄竞折腰。
    * 惜秦皇汉武，略输文采；唐宗宋祖，稍逊风骚。
    * 一代天骄，成吉思汗，只识弯弓射大雕。
    * 俱往矣，数风流人物，还看今朝
    */

    //UserRoleService 测试用例
    @Test
    void UserRoleServiceTest(){
        //checkUserRole() 测试用例
        int result =  userRoleService.checkUserRole(1001);

        //getAllUserRole() 测试用例
        Collection<UserRole> userRoles = userRoleService.getAllUserRole();
        System.out.println("你是个好人啊!");
        System.out.println(userRoles);

        //将 UserRole 对象保存进数据库
        //saveUserRole() 测试用例
        userRoleService.addUserRole(new UserRole(1012, 101, 902));
        Collection<UserRole> userRoles2 = userRoleService.getAllUserRole();
        System.out.println(userRoles);

        //alterUserRole() 测试用例
        int alterResult = 0;
        userRoleService.alterUserRole(new UserRole(1001, 102, 902));
        System.out.println(alterResult);
    }
}
