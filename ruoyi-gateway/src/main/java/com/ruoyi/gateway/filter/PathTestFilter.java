//package com.ruoyi.gateway.filter;
//
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
///**
// *  测试自定过滤器的使用
// * @author Carl
// * @since 1.1.1
// */
//public class PathTestFilter implements GatewayFilter {
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        // 你的过滤逻辑
//        System.err.println("CaptchaFilter: 处理 /captcha 请求");
//        // 继续处理请求
//        return chain.filter(exchange);
//    }
//}
