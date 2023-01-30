package cn.zengchen233.interceptor;

import cn.zengchen233.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author zengchen
 * @title PrivilegeInterceptor
 * @description TODO
 * @create 2023/1/30 9:40
 */
public class PrivilegeInterceptor implements HandlerInterceptor {

    /**
     * @description: 判断用户是否登录
     * @param request
     * @param response
     * @param handler
     * @return: boolean
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return false;
        }
        //放行 访问目标资源
        return true;
    }
}
