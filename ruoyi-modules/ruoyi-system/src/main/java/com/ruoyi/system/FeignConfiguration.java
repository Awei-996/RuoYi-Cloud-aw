package com.ruoyi.system;

import feign.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author Carl
 * @since 6.1.0
 */
//@Configuration
//public class FeignConfiguration {
//
//    @PostConstruct
//    public void setLogLevel() {
//        // 获取日志上下文并设置包级别日志
//        ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.ruoyi.system.api");
//        // 设置日志级别为 DEBUG
//        logger.setLevel(ch.qos.logback.classic.Level.DEBUG);
//    }
//
//    @Bean
//    public Logger.Level getLog()
//    {
//        return Logger.Level.BASIC;
//    }
//}
