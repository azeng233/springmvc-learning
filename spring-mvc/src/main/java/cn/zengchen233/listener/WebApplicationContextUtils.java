package cn.zengchen233.listener;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

/**
 * @author zengchen
 * @title WebApplicationContextUtils
 * @description TODO
 * @create 2023/1/16 10:49
 */
public class WebApplicationContextUtils {
    public static ApplicationContext getWebApp(ServletContext servletContext) {
        return (ApplicationContext) servletContext.getAttribute("app");
    }
}
