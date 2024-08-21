//package com.ruoyi.gateway.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///**
// * 定义拦截器，用于拦截MVC格式的请求
// * @author Carl
// * @since 1.1.1
// */
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    @Autowired
//    private CaptchaInterceptor captchaInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(captchaInterceptor).addPathPatterns("/captcha");
//    }
//}
