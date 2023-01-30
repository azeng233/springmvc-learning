package cn.zengchen233.resolver;

import cn.zengchen233.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zengchen
 * @title MyExceptionResolver
 * @description TODO
 * @create 2023/1/30 11:30
 */
public class MyExceptionResolver implements HandlerExceptionResolver {
    /**
     * @description: TODO
     * @param request
     * @param response
     * @param handler
     * @param ex 异常对象
     * @return: org.springframework.web.servlet.ModelAndView 要跳转的错误视图信息
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView view = new ModelAndView();
        if (ex instanceof MyException) {
            view.addObject("info", "自定义异常");
        } else if (ex instanceof ClassCastException) {
            view.addObject("info", "类转换异常");
        }
        view.setViewName("error");
        return view;
    }
}
