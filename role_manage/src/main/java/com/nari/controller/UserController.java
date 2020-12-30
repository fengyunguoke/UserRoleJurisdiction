package com.nari.controller;

import com.nari.dao.UserDao;
import com.nari.pojo.User;
import com.nari.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;

    //从数据库读所有用户
    @RequestMapping("/emps")
    public String userList(Model model){
        Collection<User> users = userService.getAllUser();
        model.addAttribute("emps",users);
        return "emp/list";
    }

    @RequestMapping("/emps102")
    public String userList102(Model model){
        Collection<User> users = userService.getAllUser();
        model.addAttribute("emps",users);
        return "emp/list102";
    }

    @GetMapping("/toAdd")
    public String add(Model model){
        model.addAttribute("user", new User());
        return "emp/add";
    }
    @GetMapping("/toAdd102")
    public String add102(Model model){
        model.addAttribute("user", new User());
        return "emp/add102";
    }


    //数据库增
    @PostMapping("/emp")
    public String addUser(@ModelAttribute User user){
        userService.addUser(user);
        return "redirect:/emps";
    }
    @PostMapping("/emp102")
    public String addUser102(User user){
        userService.addUser(user);
        return "redirect:/emps102";
    }

    //删除用户
    @RequestMapping("/toDelete/{userId}")
    public String deleteById(@PathVariable("userId") int userId){
        String deleteResult = null;
        deleteResult =  userService.deleteUser(userId);
        System.out.println("数据库是否删除成功==>" + deleteResult);      //测试是否删除成功

        return "redirect:/emps";
    }


    /*@GetMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id") int id, Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        Employee employee = userDao.get(id);
        model.addAttribute("emp",employee);
        return "emp/update";
    }*/

    /*@GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        userDao.delete(id);
        return "redirect:/emps";
    }*/
}
