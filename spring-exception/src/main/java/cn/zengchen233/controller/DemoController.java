package cn.zengchen233.controller;

import cn.zengchen233.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zengchen
 * @title DemoController
 * @description TODO
 * @create 2023/1/30 10:42
 */
@Controller
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/show")
    public String show(@RequestParam(value = "name", required = true) String name) {

    }
}
