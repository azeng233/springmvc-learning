package cn.zengchen233.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author zengchen
 * @title ContextLoaderListener
 * @description TODO
 * @create 2023/1/16 10:23
 */
@WebListener
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //读取web.xml全局参数
        ServletContext context = sce.getServletContext();
        String location = context.getInitParameter("contextConfigLocation");

        ApplicationContext app = new ClassPathXmlApplicationContext(location);
        //将Spring应用上下文对象存储在ServletContext中
        context.setAttribute("app", app);
        System.out.println("Spring容器启动完毕...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
