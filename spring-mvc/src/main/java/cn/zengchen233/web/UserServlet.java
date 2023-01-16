package cn.zengchen233.web;

import cn.zengchen233.listener.WebApplicationContextUtils;
import cn.zengchen233.service.UserService;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zengchen
 * @title UserServlet
 * @description TODO
 * @create 2023/1/16 9:59
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        //ApplicationContext app = (ApplicationContext) context.getAttribute("app");
        ApplicationContext app = WebApplicationContextUtils.getWebApp(context);
        UserService bean = app.getBean(UserService.class);
        bean.save();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
