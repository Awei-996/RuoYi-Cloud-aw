//package com.ruoyi.gateway.filter;
//
//import com.ruoyi.common.redis.service.RedisService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import org.springframework.util.CollectionUtils;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.util.Objects;
//import java.util.Set;
//
///**
// * 不建议这样使用，不符合实际生产，应该在全局过滤器中来进行黑名单过滤
// * 黑名单IP过滤器
// * yml配置方法：
// *         - name: BlackListIpFilter
// *           args:
// *             blackList:
// *               - "2.2.3.4"
// *               - "4.4.56.5"
// * @author Carl
// * @since 6.1.0
// */
//@Component
//@Order(Integer.MIN_VALUE)
//public class BlackListIpFilter extends AbstractGatewayFilterFactory<BlackListIpFilter.Config> {
//
//    private final String BLACK_SET_KEY = "gateway:blackSet";
//
//    @Autowired
//    private RedisService redisService;
//
//    public BlackListIpFilter() {
//        super(Config.class);
//    }
//
//
//    @Override
//    public GatewayFilter apply(Config config) {
//        // 测试添加一个地址
//        redisService.addCacheSet(BLACK_SET_KEY,"1.1.1.1");
//        if (!CollectionUtils.isEmpty(config.getBlackList())) {
//            redisService.setCacheSet(BLACK_SET_KEY, config.getBlackList());
//        }
//        return (ServerWebExchange exchange, GatewayFilterChain chain) -> {
//
//            String hostString = Objects.requireNonNull(exchange.getRequest().getRemoteAddress()).getHostString();
//            System.err.println("hostString:"+hostString);
//           // 先从配置文件判断
//            if (!CollectionUtils.isEmpty(config.getBlackList())&&config.getBlackList().contains(hostString)) {
//                return Mono.error(new RuntimeException("IP地址被拉黑"));
//            }
//            // 再从缓存判断
//            Set<String> cacheSet = redisService.getCacheSet(BLACK_SET_KEY );
//            if (!CollectionUtils.isEmpty(cacheSet)&&cacheSet.contains(hostString)) {
//                return Mono.error(new RuntimeException("IP地址被拉黑"));
//            }
//
//            return chain.filter(exchange);
//        };
//    }
//
//
//    public static class Config {
//
//        private Set<String> blackList;
//
//        public Set<String> getBlackList() {
//            return blackList;
//        }
//        // 这个set方法必须写，因为yml中的参数时通过这个方法传过去的
//        public void setBlackList(Set<String> blackList) {
//            this.blackList = blackList;
//        }
//    }
//}
