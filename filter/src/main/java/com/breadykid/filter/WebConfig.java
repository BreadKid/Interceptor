package com.breadykid.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: 拦截器注册
 * @author: Joyce Liu
 * @create: 2020-05-31 20:32
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AInterceptor aInterceptor;

    @Autowired
    private BInterceptor bInterceptor;

    /**
     * 添加自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(aInterceptor);
        registry.addInterceptor(bInterceptor);
    }
}
