package com.breadykid.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 自定义拦截器A
 * @author: Joyce Liu
 * @create: 2020-05-31 20:10
 */
@Component
public class AInterceptor implements HandlerInterceptor {

    /**
     * 在请求处理之前进行调用
     * 链式调用:每个Interceptor的调用会依据它的声明顺序依次执行，
     * 而且最先执行的都是Interceptor中的preHandle方法
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("startTime", System.currentTimeMillis());
        // 验证token
        // 验证入参
        if (request.getParameter("str").equals("error")) {
            return false;
        }
        Thread.sleep(1000);
        return true;
    }

    /**
     * 在当前请求进行处理之后执行(Controller 方法调用之后)
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 当前对应的Interceptor的preHandle方法的返回值为true时才会执行
     * 用于进行资源清理工作
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("拦截器A处理耗时 "+(System.currentTimeMillis() - (long)request.getAttribute("startTime"))+"毫秒");
    }
}
