package cn.zengchen233.controller;

import cn.zengchen233.pojo.Role;
import cn.zengchen233.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author zengchen
 * @title RoleController
 * @description TODO
 * @create 2023/1/31 10:49
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public ModelAndView list() {
        ModelAndView view = new ModelAndView();
        List<Role> roleList = roleService.list();
        //设置模型
        view.addObject("roleList", roleList);
        //设置视图
        view.setViewName("role-list");
        return view;
    }

    @RequestMapping("/save")
    public String save(Role role) {
        roleService.save(role);
        return "redirect:/role/list";
    }
}
