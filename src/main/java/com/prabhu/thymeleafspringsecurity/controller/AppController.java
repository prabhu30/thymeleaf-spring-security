package com.prabhu.thymeleafspringsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/auth")
    public String auth() {
        return "api-auth-new";
    }
}
