package cn.zengchen233.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zengchen
 * @title TargetController
 * @description TODO
 * @create 2023/1/27 8:43
 */
@Controller
public class TargetController {
    @RequestMapping("/target")
    public ModelAndView show() {
        System.out.println("目标资源执行...");
        ModelAndView view = new ModelAndView();
        view.addObject("name", "曾晨");
        view.setViewName("index");
        return view;
    }
}
