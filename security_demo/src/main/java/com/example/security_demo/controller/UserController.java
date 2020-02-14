package com.example.security_demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: 36560
 * @Date: 2020/2/12 :11:15
 * @Description:
 */
@RestController
@RequestMapping
public class UserController {

    @GetMapping("/me")
    public Object me() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @GetMapping("/user")
    public ResponseEntity creat() {
        return ResponseEntity.ok("创建成功");
    }
}
