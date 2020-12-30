package com.nari.controller;

import com.nari.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    RoleService roleService;

    @Autowired
    UserController userController;

    @Autowired
    UserRoleController userRoleController;

    //登录实现,不同的用户角色进入不同的菜单页面，角色菜单中可以为用户分配角色角（用户角色表）
    @RequestMapping("/user/login")
    public String login(@RequestParam("role")String role,@RequestParam("userId")int userId,
                        @RequestParam("username") String username,
                        @RequestParam("password") String password, Model model, HttpSession session){

        //根据登陆的 userid 来确定角色、具体菜单界面，动动脑子，设置让它跳转
        //查询到的 queryResult = 101 102 103 "此用户未记录在数据库,请以管理员ID登陆！"
        /*Object o = userId;
        System.out.println(o.getClass().toString());*/

        //取得 roleId
        int roleId = userRoleController.checkUserRole(userId);

        switch (roleId)
        {
            case 101:
                if(!StringUtils.isEmpty(username)&& "123456".equals(password) && "1".equals(role)) {
                    model.addAttribute("msg", "");
                    session.setAttribute("loginUser", username);
                    //登陆成功,登录重定向，避免一直提交
                    return "redirect:/Admin.html";
                }
                else{
                    model.addAttribute("msg","登录失败，请重新登录");
                    return "index";
                }
            case 102:
                if(!StringUtils.isEmpty(username) && "123456".equals(password) && "1".equals(role)){
                    model.addAttribute("msg","");
                    session.setAttribute("loginUser",username);
                    return "redirect:/generalAdmin.html";
                }
                else{
                    model.addAttribute("msg","登录失败，请重新登录");
                    return "index";
                }
            case 103:
                if(!StringUtils.isEmpty(username) && "123456".equals(password) && "1".equals(role)){
                    model.addAttribute("msg","");
                    session.setAttribute("loginUser",username);
                    return "redirect:/User.html";
                }
                else{
                    model.addAttribute("msg","登录失败，请重新登录");
                    return "index";
                }
            default:
                model.addAttribute("msg","此用户ID未被分配相应的角色，请以其它用户ID登陆！");
                return "index";
        }


        /*switch (role)
        {
            case "1":               //表明是管理员。成吉思汗成吉思汗成吉
                if(!StringUtils.isEmpty(username)&& "123456".equals(password)) {
                    model.addAttribute("msg", "");
                    session.setAttribute("loginUser", username);
                    //登陆成功,登录重定向，避免一直提交
                    return "redirect:/main.html";
                }
            case "0":
                model.addAttribute("msg","登录失败，请重新登录");
                return "index";
            default:
                System.out.println("未选择角色");
        }*/
        //return "";


        /*if(!StringUtils.isEmpty(username)&& "123456".equals(password) && "1".equals(value)){
            model.addAttribute("msg","");
            session.setAttribute("loginUser",username);
            //登陆成功,登录重定向，避免一直提交
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","登录失败，请重新登录");
            return "index";
        }*/
    }
}
