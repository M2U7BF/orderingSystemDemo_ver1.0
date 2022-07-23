package com.example.ordering.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("login")
    public String login(){
        return "auth/login";
    }

    @PostMapping("login{verify}")
    public String loginVerify(){
        return "redirect:/service";
    }
    
    @GetMapping("createAccount")
    public String createAccount(){
        return "auth/createAccount";
    }

    @GetMapping("logout")
    public String logout(){
        return "auth/logout";
    }

    @GetMapping("passwordReset")
    public String passwordReset(){
        return "auth/passwordReset";
    }
}
