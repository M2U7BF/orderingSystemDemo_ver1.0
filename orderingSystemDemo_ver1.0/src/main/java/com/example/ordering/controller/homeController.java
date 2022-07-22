package com.example.ordering.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {
	@GetMapping("service")
	public String service() {
		return "service";
	}

}
