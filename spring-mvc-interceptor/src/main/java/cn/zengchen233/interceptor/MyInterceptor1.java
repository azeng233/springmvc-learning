package cn.zengchen233.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zengchen
 * @title MyInterceptor
 * @description TODO
 * @create 2023/1/27 9:01
 */
public class MyInterceptor1 implements HandlerInterceptor {
    /**
     * @description: 在目标方法执行之前
     * @param request
     * @param response
     * @param handler
     * @return: boolean
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        String param = request.getParameter("param");
        if ("yes".equals(param)) {
            return true;
        } else {
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return false;
        }
    }

    /**
     * @description: 在目标方法执行之后，视图方法返回之前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @return: void
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("name", "向蔚思");
        System.out.println("postHandle");
    }

    /**
     * @description: 在整个流程执行完毕后执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @return: void
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
