package com.example.ordering.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ordering.form.AccountForm;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	@ModelAttribute
	public AccountForm initializeForm() {
		AccountForm accountForm = new AccountForm();
		return accountForm;
	}

    @GetMapping("login")
    public String login(){
        return "auth/login";
    }

    @PostMapping("login{verify}")
    public String loginVerify(@Validated AccountForm accountForm, BindingResult result){
    	if(result.hasErrors()) {
    		return "auth/login";
    	}
    	
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
