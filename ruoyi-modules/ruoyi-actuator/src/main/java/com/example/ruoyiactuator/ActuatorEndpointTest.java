package com.example.ruoyiactuator;

import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Carl
 * @since 6.1.0
 */
@RestControllerEndpoint(id = "myActuator") // 标识这是一个actuator组件暴露端点
@Component //交给Spring容器管理
public class ActuatorEndpointTest {

    @GetMapping
    public Map<Object, Object> getMyActuator() {
        Map<Object, Object> resultMap = new HashMap<>();

        resultMap.put("status", "UP");
        resultMap.put("msg", "我是测试数据...");

        return resultMap;
    }

}
