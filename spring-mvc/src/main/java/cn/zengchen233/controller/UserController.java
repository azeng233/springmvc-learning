package cn.zengchen233.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zengchen
 * @title UserController
 * @description TODO
 * @create 2023/1/17 10:05
 */
@Controller
public class UserController {
    @RequestMapping("/quick")
    public String save() {
        System.out.println("Controller save money...");
        return "success.jsp";
    }
}
