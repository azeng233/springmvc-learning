package cn.zengchen233.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zengchen
 * @title UserController
 * @description TODO
 * @create 2023/1/17 10:05
 */
@Controller
@RequestMapping("/user")
public class UserController {
    //请求地址 http://localhost:8080/user/quick
    @RequestMapping("/quick")
    public String save1() {
        System.out.println("Controller save money...");
        return "success";
    }

    @RequestMapping("/a")
    public ModelAndView save2() {
        /*
         * Model:模型 作用封装数据
         * View:视图 作用展示数据
         */
        ModelAndView view = new ModelAndView();
        //设置模型数据
        view.addObject("username", "曾晨");
        //设置视图名称
        view.setViewName("success");
        return view;
    }

    @RequestMapping("/b")
    public ModelAndView save3(ModelAndView view) {
        //设置模型数据
        view.addObject("username", "妈妈");
        //设置视图名称
        view.setViewName("success");
        return view;
    }

    @RequestMapping("/c")
    public String save4(Model model) {
        model.addAttribute("username", "爸爸");
        return "success";
    }
    /*
     * @description: 不常用
     * @param req
     * @return: java.lang.String
     */
    @RequestMapping("/d")
    public String save5(HttpServletRequest req) {
        req.setAttribute("username","爷爷");
        return "success";
    }
}
