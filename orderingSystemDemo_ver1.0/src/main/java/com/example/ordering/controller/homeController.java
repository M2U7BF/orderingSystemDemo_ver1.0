package com.example.ordering.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ordering.entity.Vegetables;

@Controller
public class homeController {
	@GetMapping("service")
	public String serviceView() {
		// 戻り値は「ビュー名」を返す
		return "service";
	}
	
	@GetMapping("choice")
	public String choiceView(Model model) {
		Vegetables veg1 = new Vegetables("芽キャベツ1", "1kg", 700);
		Vegetables veg2 = new Vegetables("芽キャベツ2", "1束", 80);
		Vegetables veg3 = new Vegetables("芽キャベツ3", "1個", 30);
		Vegetables veg4 = new Vegetables("芽キャベツ4", "1kg", 550);
		Vegetables veg5 = new Vegetables("芽キャベツ5", "1kg", 630);
		Vegetables veg6 = new Vegetables("芽キャベツ6", "1kg", 410);
		Vegetables veg7 = new Vegetables("芽キャベツ7", "1kg", 312);
		Vegetables veg8 = new Vegetables("芽キャベツ8", "1kg", 520);
		Vegetables veg9 = new Vegetables("芽キャベツ9", "1kg", 633);
		Vegetables veg10 = new Vegetables("芽キャベツ10", "1kg", 610);

		List<Vegetables> vegetables = new ArrayList<>();
		vegetables.add(veg1);
		vegetables.add(veg2);
		vegetables.add(veg3);
		vegetables.add(veg4);
		vegetables.add(veg5);
		vegetables.add(veg6);
		vegetables.add(veg7);
		vegetables.add(veg8);
		vegetables.add(veg9);
		vegetables.add(veg10);

		model.addAttribute("vegetables",vegetables);
		
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
