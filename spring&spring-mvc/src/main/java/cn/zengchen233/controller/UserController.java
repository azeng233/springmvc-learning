package cn.zengchen233.controller;

import cn.zengchen233.pojo.Role;
import cn.zengchen233.pojo.User;
import cn.zengchen233.service.RoleService;
import cn.zengchen233.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zengchen
 * @title UserController
 * @description TODO
 * @create 2023/2/1 9:35
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView view = new ModelAndView();
        List<User> userList = userService.list();
        view.addObject("userList", userList);
        view.setViewName("user-list");
        return view;
    }

    @RequestMapping("/add")
    public ModelAndView add() {
        ModelAndView view = new ModelAndView();
        List<Role> roleList = roleService.list();
        view.addObject("roleList", roleList);
        view.setViewName("user-add");
        return view;
    }

    @RequestMapping("/save")
    public String save(User user, Long[] roleIds) {
        userService.save(user, roleIds);
        return "redirect:/user/list";
    }

    @RequestMapping("/del/{userID}")
    public String del(@PathVariable("userID") Long id) {
        userService.del(id);
        return "redirect:/user/list";
    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session) {
        User user = userService.login(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/index.jsp";
        }
        return "redirect:/login.jsp";
    }
}
