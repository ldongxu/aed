package com.aed.common.config;

import com.aed.interceptor.AppLoginInterceptor;
import com.aed.interceptor.CmsLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author liudongxu06
 * @date 2018/9/29
 */
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CmsLoginInterceptor()).addPathPatterns("/cms/**");
        registry.addInterceptor(new AppLoginInterceptor()).addPathPatterns("/cgi/**");
    }
}
