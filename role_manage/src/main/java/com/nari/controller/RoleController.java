package com.nari.controller;

import com.nari.mapper.RoleMapper;
import com.nari.pojo.Role;
import com.nari.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

//角色控制层
@Controller
public class RoleController {

    @Autowired
    RoleService roleService;

    //角色列表展示
    @RequestMapping("/getAllRole")
    public String roleList(Model model){
        List<Role> roles = roleService.getAllRole();
        //System.out.println(roles);            测试一下看是否取到值
        model.addAttribute("roles",roles);
        return "role/roleList";
    }

    //跳转到增加角色
    @GetMapping("/toAddRole")
    public String addRole(Model model){

        model.addAttribute("role",new Role());
        //跳转到添加页面
        return "role/addRole";
    }
    //添加角色
    @PostMapping("/rol")
    public String addEmp(@ModelAttribute Role role){        //取到从前端传来的 Role 对象
        Role newRole = new Role();
        newRole.setRoleId(role.getRoleId());
        newRole.setRoleName(role.getRoleName());
        newRole.setRoleComment(role.getRoleComment());
        System.out.println("newRole:" + newRole);       //确定 newRole 对象中已经保存有来自前端 form 表单的数据，接着保存进数据库即可


        //调用业务层方法将 role 对象存进数据库
        roleService.addRole(newRole);
        return "redirect:/getAllRole";                                 //跳转是没问题的
    }

    //测试 Mybatis
    /*@RequestMapping("/getAllRole")
    public List<Role> getAllRole(){
        System.out.println("fkkkkk");
        List<Role> roles = roleMapper.getAllRole();

        System.out.println(roles);
        System.out.println(roles.isEmpty());

        for (Role role : roles) {               //测试一下
            System.out.println("这是 Mybatis 取得的 Role 对象==>" + role);
        }
        return roles;
    }*/
}
