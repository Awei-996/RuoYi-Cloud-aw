package com.example.ruoyiactuator.config;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

/**
 * @author Carl
 * @since 6.1.0
 */
@Component
@Endpoint(id = "customEndpoint")
public class CustomEndpoint {

    @ReadOperation
    public String customReadOperation() {
        return "This is a custom read operation!";
    }

    @WriteOperation
    public String customWriteOperation(String message) {
        return "You posted: " + message;
    }
}
