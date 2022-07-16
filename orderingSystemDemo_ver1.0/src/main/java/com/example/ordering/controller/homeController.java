package com.example.ordering.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {
	@GetMapping("service")
	public String serviceView() {
		// 戻り値は「ビュー名」を返す
		return "service";
	}
	
	@GetMapping("choice")
	public String choiceView() {
		// 戻り値は「ビュー名」を返す
		return "choice";
	}
	
	@GetMapping("confirm")
	public String confirmView() {
		// 戻り値は「ビュー名」を返す
		return "confirm";
	}
	
	@GetMapping("confirmed")
	public String confirmedView() {
		// 戻り値は「ビュー名」を返す
		return "confirmed";
	}
}
