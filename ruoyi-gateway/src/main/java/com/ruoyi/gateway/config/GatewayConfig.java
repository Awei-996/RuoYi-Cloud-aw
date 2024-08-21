package com.ruoyi.gateway.config;

import com.ruoyi.gateway.handler.SentinelFallbackHandler;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * 网关限流配置
 *
 * @author ruoyi
 */
@Configuration
public class GatewayConfig {
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SentinelFallbackHandler sentinelGatewayExceptionHandler() {
        return new SentinelFallbackHandler();
    }

//    /**
//     * 我们除了使用yml方式来添加路由，还可以使用这种方式添加
//     * yml的本质也是这种方式，这种添加了会走全局过滤器,则例需要注意 如果GlobalFilter 实现了Ordered接口设置
//     *  order的值都会比默认值小，所以全局过滤会走在stripPrefix 这种网关过滤器,如果全局过滤器没有实现Ordered接口，
//     *  就会根据网关过滤器的顺序执行，然后在执行全局过滤器，还可以使用自定义过滤器{@link PathTestFilter}
//     *
//     * @param routeLocatorBuilder
//     * @return
//     */
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
//        // 构建多个路由routes
//        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
//
////        routes.route("path_test", r -> r.path("/test/**").filters(f -> f.stripPrefix(1)).uri("http://localhost:9000")).build();
//
//        routes.route("path_test", r -> r.path("/dev-api/**")
//                .filters(f -> f.stripPrefix(1).filter(new PathTestFilter()))
//                .uri("http://localhost:8888")).build();
//        return routes.build();
//
//    }
}