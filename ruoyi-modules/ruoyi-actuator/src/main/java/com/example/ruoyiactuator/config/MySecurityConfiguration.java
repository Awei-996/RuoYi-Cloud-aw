package com.example.ruoyiactuator.config;


/**
 * @author Carl
 * @since 6.1.0
 */
import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration(proxyBeanMethods = false)
public class MySecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.requestMatcher(EndpointRequest.toAnyEndpoint());
//        http.authorizeRequests((requests) -> requests.anyRequest().permitAll());
        http.authorizeRequests((requests) -> requests.antMatchers("/actuator/info").permitAll());
        return http.build();
    }

}

