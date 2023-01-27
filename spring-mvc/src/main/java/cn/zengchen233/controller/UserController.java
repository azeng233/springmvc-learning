package cn.zengchen233.controller;

import cn.zengchen233.pojo.User;
import cn.zengchen233.pojo.VO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

    /**
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

    @RequestMapping("/aa")
    @ResponseBody
    public void save11(String username, int age) {
        System.out.println("username = " + username + ", age = " + age);
    }

    @RequestMapping("/bb")
    @ResponseBody
    public void save12(User user) {
        System.out.println(user);
    }

    @RequestMapping("/cc")
    @ResponseBody
    public void save13(String[] str) {
        System.out.println(Arrays.asList(str));
    }

    @RequestMapping("/dd")
    @ResponseBody
    public void save14(VO vo) {
        System.out.println(vo);
    }

    @RequestMapping("/ee")
    @ResponseBody
    public void save15(@RequestBody List<User> list) {
        System.out.println(list);
    }

    @RequestMapping("/ff")
    @ResponseBody
    public void save16(@RequestParam(value = "name", required = false, defaultValue = "sxm") String username) {
        System.out.println(username);
    }

    /**
      * @description: 请求路径必须要和@PathVariable里面的value一致
      * @param name
      * @return: void
      */
    @RequestMapping(value = "/gg/{name}", method = RequestMethod.GET)
    @ResponseBody
    public void save17(@PathVariable(value = "name", required = false) String name) {
        System.out.println(name);
    }

    @RequestMapping("/hh")
    @ResponseBody
    public void save18(Date date) {
        System.out.println(date);
    }

    @RequestMapping("/ii")
    @ResponseBody
    public void save19(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        System.out.println("req = " + req + ", resp = " + resp + ", session = " + session);
    }

    @RequestMapping("/aaa")
    @ResponseBody
    public void save20(@RequestHeader(value = "User-Agent", required = false) String user_agent) {
        System.out.println(user_agent);
    }

    @RequestMapping("/bbb")
    @ResponseBody
    public void save21(@CookieValue(value = "JSESSIONID") String jsessionid) {
        System.out.println(jsessionid);
    }

    @RequestMapping("/ccc")
    @ResponseBody
    public void save22(String name, MultipartFile file1, MultipartFile file2) throws IOException {
        System.out.println(name);
        String filename1 = file1.getOriginalFilename();
        file1.transferTo(new File("F:\\upload\\" + filename1));
        String filename2 = file2.getOriginalFilename();
        file2.transferTo(new File("F:\\upload\\" + filename2));
    }

    /**
     * @description: 使用数组接受
     * @param name
     * @param files
     * @return: void
     */
    @RequestMapping("/ddd")
    @ResponseBody
    public void save23(String name, MultipartFile @NotNull [] files) throws IOException {
        System.out.println(name);
        for (MultipartFile file : files) {
            String filename = file.getOriginalFilename();
            file.transferTo(new File("F:\\upload\\" + filename));
        }
    }
}
