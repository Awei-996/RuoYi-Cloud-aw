package com.ruoyi.system.api;

import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Carl
 * @since 6.1.0
 */
public interface RoleFeignClient {

    /**
     * 获取角色列表
     */
    @PostMapping("/list")
    void listRole();
}