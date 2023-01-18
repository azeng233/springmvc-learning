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
@RequestMapping("/user")
public class UserController {
    //请求地址 http://localhost:8080/quick
    @RequestMapping("/quick")
    public String save() {
        System.out.println("Controller save money...");
        return "success";
    }
}
