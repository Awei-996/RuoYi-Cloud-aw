package com.ruoyi.gateway.controller;

import com.ruoyi.common.core.exception.CaptchaException;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.gateway.service.ValidateCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * TODO 将验证的方式改为MVC格式获取
 * @author Carl
 * @since 6.1.0
 */
@RestController
@RequestMapping("/code")
public class ValidateCodeController {

    @Autowired
    private  ValidateCodeService validateCodeService;

    @GetMapping
    public ResponseEntity<AjaxResult> createCaptcha(HttpServletRequest request) {
        AjaxResult ajax;
        try {
            System.err.println(request.getRemoteAddr());
            ajax = validateCodeService.createCaptcha();
            System.err.println(ajax);
            System.out.println("1111111111111111");
        } catch (CaptchaException | IOException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(ajax, HttpStatus.OK);
    }
}
