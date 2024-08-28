package com.ruoyi.system.controller;

import com.ruoyi.system.api.RemoteFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Carl
 * @since 6.1.0
 */
@RestController
public class TestFeignController {

    @Autowired
    private RemoteFileService remoteFileService;
    @GetMapping("/test")
    public String test() {
        return remoteFileService.t1("aw");
    }
}
