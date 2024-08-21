//package com.ruoyi.gateway.config;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * MVC 格式拦截器 现在依赖问题解决，暂不使用这个拦截器
// * @author Carl
// * @since 1.1.1
// */
//@Component
//public class CaptchaInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//       if ("/captcha".equals(request.getPathInfo())) {
//           System.out.println("CaptchaInterceptor: 处理 /captcha 请求");
//           return true;
//       }
//
//        return false;
//    }
//}
