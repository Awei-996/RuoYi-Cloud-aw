//package com.ruoyi.gateway.config;
//
//import com.ruoyi.common.core.constant.HttpStatus;
//import com.ruoyi.common.core.utils.ServletUtils;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import org.springframework.web.server.WebFilter;
//import org.springframework.web.server.WebFilterChain;
//import reactor.core.publisher.Mono;
//
//
///**
// * RouterFunction方式可以用这种凡是过滤
// * @author Carl
// * @since 6.1.0
// */
//@Component
//public class MyWebFilter implements WebFilter {
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
//        // 这里是过滤逻辑，例如获取路径
//        String path = exchange.getRequest().getPath().toString();
//        System.err.println(path);
//        if ("/captcha".equals(path)) {
//            return chain.filter(exchange);
//        }
//        return ServletUtils.webFluxResponseWriter(exchange.getResponse(), "无效路径", HttpStatus.NOT_FOUND);
//    }
//}
