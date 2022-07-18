package com.example.ordering.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.ordering.entity.Fruits;
import com.example.ordering.entity.User;
import com.example.ordering.entity.Vegetables;
import com.example.ordering.form.Form;

@Controller
@SessionAttributes(value = "itemData")
public class homeController {
	
	@ModelAttribute(value = "itemData")
	public Form setUpForm() {
		System.out.println("itemData created");
		return new Form();
	}
	
	@GetMapping("service")
	public String serviceView() {
		return "service";
	}
	
	@GetMapping("choice")
	public String choiceView(@ModelAttribute(value = "itemData")Form f, Model model) {
		Vegetables veg1 = new Vegetables(11, "芽キャベツ1", "1kg", 700);
		Vegetables veg2 = new Vegetables(12, "芽キャベツ2", "1束", 80);
		Vegetables veg3 = new Vegetables(13, "芽キャベツ3", "1個", 30);
		Vegetables veg4 = new Vegetables(14, "芽キャベツ4", "1kg", 550);
		Vegetables veg5 = new Vegetables(15, "芽キャベツ5", "1kg", 630);
		Vegetables veg6 = new Vegetables(16, "芽キャベツ6", "1kg", 410);
		Vegetables veg7 = new Vegetables(17, "芽キャベツ7", "1kg", 312);
		Vegetables veg8 = new Vegetables(18, "芽キャベツ8", "1kg", 520);
		Vegetables veg9 = new Vegetables(19, "芽キャベツ9", "1kg", 633);
		Vegetables veg10 = new Vegetables(110, "芽キャベツ10", "1kg", 610);

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

		Fruits frt1 = new Fruits(21, "ポンカン1", "1kg", 1200);
		Fruits frt2 = new Fruits(22, "ポンカン2", "1袋", 420);
		Fruits frt3 = new Fruits(23, "ポンカン3", "1個", 130);
		Fruits frt4 = new Fruits(24, "ポンカン4", "1kg", 450);
		Fruits frt5 = new Fruits(25, "ポンカン5", "1kg", 830);
		Fruits frt6 = new Fruits(26, "ポンカン6", "1kg", 910);
		Fruits frt7 = new Fruits(27, "ポンカン7", "1kg", 1012);
		Fruits frt8 = new Fruits(28, "ポンカン8", "1kg", 920);
		Fruits frt9 = new Fruits(29, "ポンカン9", "1kg", 733);
		Fruits frt10 = new Fruits(210, "ポンカン10", "1kg", 510);

		List<Fruits> fruits = new ArrayList<>();
		fruits.add(frt1);
		fruits.add(frt2);
		fruits.add(frt3);
		fruits.add(frt4);
		fruits.add(frt5);
		fruits.add(frt6);
		fruits.add(frt7);
		fruits.add(frt8);
		fruits.add(frt9);
		fruits.add(frt10);

		model.addAttribute("fruits",fruits);
		
		User user1 = new User("A店");
		model.addAttribute("user",user1);
		
		model.addAttribute(f);
		
		return "choice";
	}
	
	@PostMapping("confirm")
	public String confirmView(@ModelAttribute(value = "itemData")Form f, Model model) {
		model.addAttribute(f);
		return "confirm";
	}
	
	@PostMapping("confirmed")
	public String confirmedView(@ModelAttribute(value = "itemData")Form f, Model model) {
		model.addAttribute(f);
		return "confirmed";
	}
}
