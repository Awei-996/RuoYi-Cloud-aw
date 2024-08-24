package com.ruoyi.gateway.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Carl
 * @since 6.1.0
 */
@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "security.black.ip")
public class BlackIpProperties {

    /**
     * 默认不开启
     */
    private Boolean enabled = false;

    private Set<String> blackIpSet = new HashSet<>();


    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<String> getBlackIpSet() {
        return blackIpSet;
    }

    public void setBlackIpSet(Set<String> blackIpSet) {
        this.blackIpSet = blackIpSet;
    }
}
