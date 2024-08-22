package com.ruoyi.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;


/**
 * 限流规则配置类
 *
 * @author Carl
 * @since 6.1.0
 */
@Configuration
public class KeyResolverConfiguration {

    /**
     * 路径限流
     *
     * @return
     */
    @Bean
    public KeyResolver pathKeyResolver() {
        return exchange -> {
            System.err.println("限流路径：" + exchange.getRequest().getURI().getPath());
            return Mono.just(exchange.getRequest().getURI().getPath());
        };
    }

    /**
     * 根据用户限流
     *
     * @return
     */
    @Bean
    public KeyResolver parameterKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));
    }


    /**
     * 根据IP限流
     * @return
     */
    @Bean(value = "ipKeyResolver")
    public KeyResolver ipKeyResolver() {
        return exchange -> {
            String ip = exchange.getRequest().getRemoteAddress().getAddress().getHostAddress();
            System.err.println("ip:{}"+ip);
            return Mono.just(ip);
        };
    }
}
