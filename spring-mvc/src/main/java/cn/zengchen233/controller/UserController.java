package cn.zengchen233.controller;

import cn.zengchen233.pojo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @RequestMapping("/e")
    public void save6(HttpServletResponse resp) throws IOException {
        resp.getWriter().print("<h1>Hello World!</h1>");
    }

    /**
     * @description: @ResponseBody告知SpringMVC框架不进行视图跳转 直接进行数据相应
     * @param
     * @return: java.lang.String
     */
    @RequestMapping("/f")
    @ResponseBody
    public String save7() {
        return "<h1>Hello World!</h1>";
    }

    /**
     * @description: @ResponseBody告知SpringMVC框架不进行视图跳转 直接进行数据相应
     * @param
     * @return: java.lang.String
     */
    @RequestMapping("/g")
    @ResponseBody
    public String save8() {
        return "{\"username\":\"zengchen\",\"age\":21}";
    }

    @RequestMapping("/h")
    @ResponseBody
    public String save9(HttpServletRequest req) throws IOException {
        req.setCharacterEncoding("utf-8");
        User user = new User("zcc", 22);
        //使用json转换工具将对象转换成json格式字符串
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        return json;
    }

    /*
     * @description: 期望SpringMVC自动将User转化成json格式字符串
     * @param
     * @return: cn.zengchen233.pojo.User
     */
    @RequestMapping("/i")
    @ResponseBody
    public User save10() {
        User user = new User("zengchen", 21);
        return user;
    }
}
