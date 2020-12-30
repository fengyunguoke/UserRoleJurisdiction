package com.nari.controller;

import com.nari.pojo.Role;
import com.nari.pojo.UserRole;
import com.nari.service.RoleService;
import com.nari.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
//@RequestMapping("/userRoleController") ，怎么实现代码的复用，怎么降低代码的冗余，有待解决的问题
public class UserRoleController {

    @Autowired
    UserRoleService userRoleService;

    @Autowired
    RoleService roleService;

    //根据 userId 查询对应角色和被分配的菜单
    public int checkUserRole(int userId){
        int queryResult = userRoleService.checkUserRole(userId);
        return queryResult;
    }

    //用户角色列表展示
    @RequestMapping("/userRoleList")
    public String userRoleList(Model model){
        Collection<UserRole> userRoles = userRoleService.getAllUserRole();
        model.addAttribute("userRoles",userRoles);
        return  "user_role/userRoleList";
    }

    //新增用户角色
    @RequestMapping("/toAddUserRole")
    public String addUserRole(Model model){
        model.addAttribute("userRole",new UserRole());      //新建一个用户角色对象，并将之传回前端页面
        return "user_role/addUserRole";
    }
    //保存对用户角色的添加
    @PostMapping("/saveUserRole")
    public String saveUserRole(@ModelAttribute UserRole userRole){

        System.out.println("修改后的UserRole==>" + userRole);

        //将 UserRole 对象存进数据库
        userRoleService.addUserRole(userRole);
        return "redirect:/userRoleList";                        //返回列表界面
    }

    //编辑用户的角色
    @RequestMapping("/toAssignRole/{userId}")
    public String toAssignRole(@PathVariable("userId")int userId, Model model){

        Collection<Role> roles = roleService.getAllRole();
        UserRole userRole =  userRoleService.getUserRoleById(userId);

        model.addAttribute("roles",roles);
        model.addAttribute("userRole",userRole);
        return "user_role/assignRole";
    }

    //修改用户的角色，职责单一原则，谨记这条规则
    @RequestMapping("/alterUserRole")
    public String alterUserRole(@ModelAttribute UserRole userRole){
        int alterResult = 0;
        userRoleService.alterUserRole(userRole);
        System.out.println(alterResult);
        return "redirect:/userRoleList";                    //返回用户角色页面
    }

    //用户角色列表展示
    /*@GetMapping("/userRole")
    public String userRoleList(Model model){

        Collection<Map<String, Object>> userRoleList_maps = userRoleService.getAllUserRole();
        //System.out.println("controller:" + userRoleList_maps);        取到了user_role表的数据

        while (userRoleList_maps.iterator().hasNext()) {

            model.addAttribute("userRoleList_maps",userRoleList_maps.iterator().next().get("user_id"));
            return "/commons/userRoleList";
           }
        return "";

    }*/
}
