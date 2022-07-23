package com.example.ordering.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ordering.entity.Fruits;
import com.example.ordering.entity.User;
import com.example.ordering.entity.Vegetables;
import com.example.ordering.form.OrderForm;

@Controller
@RequestMapping("/order")
@SessionAttributes(value = "")
public class OrderController {
	
	@ModelAttribute
	public OrderForm setUpForm() {
		return new OrderForm();
	}
	
	 
//	@GetMapping("choice")
//	public String initialize(SessionStatus sessionStatus) {
//		sessionStatus.setComplete();
//		return "redirect:choice?initialized";
//	}
	
	@GetMapping("choice")
	public String choice(OrderForm f, Model model) {

		List<Vegetables> vegetables = new ArrayList<>();
		vegetables.add(new Vegetables(11, "芽キャベツ1", "1kg", 700));
		vegetables.add(new Vegetables(12, "芽キャベツ2", "1束", 80));
		vegetables.add(new Vegetables(13, "芽キャベツ3", "1個", 30));
		vegetables.add(new Vegetables(14, "芽キャベツ4", "1kg", 550));
		vegetables.add(new Vegetables(15, "芽キャベツ5", "1kg", 630));
		vegetables.add(new Vegetables(16, "芽キャベツ6", "1kg", 410));
		vegetables.add(new Vegetables(17, "芽キャベツ7", "1kg", 312));
		vegetables.add(new Vegetables(18, "芽キャベツ8", "1kg", 520));
		vegetables.add(new Vegetables(19, "芽キャベツ9", "1kg", 633));
		vegetables.add(new Vegetables(110, "芽キャベツ10", "1kg", 610));

		model.addAttribute("vegetables",vegetables);

		List<Fruits> fruits = new ArrayList<>();
		fruits.add(new Fruits(21, "ポンカン1", "1kg", 1200));
		fruits.add(new Fruits(22, "ポンカン2", "1袋", 420));
		fruits.add(new Fruits(23, "ポンカン3", "1個", 130));
		fruits.add(new Fruits(24, "ポンカン4", "1kg", 450));
		fruits.add(new Fruits(25, "ポンカン5", "1kg", 830));
		fruits.add(new Fruits(26, "ポンカン6", "1kg", 910));
		fruits.add(new Fruits(27, "ポンカン7", "1kg", 1012));
		fruits.add(new Fruits(28, "ポンカン8", "1kg", 920));
		fruits.add(new Fruits(29, "ポンカン9", "1kg", 733));
		fruits.add(new Fruits(210, "ポンカン10", "1kg", 510));

		model.addAttribute("fruits",fruits);
		
		User user1 = new User("A店");
		model.addAttribute("user",user1);
		
		model.addAttribute(f);
		
		return "order/choice";
	}

	@PostMapping("choice{correct}")
	public String CorrectChoice(OrderForm f, Model model) {

		List<Vegetables> vegetables = new ArrayList<>();
		vegetables.add(new Vegetables(11, "芽キャベツ1", "1kg", 700));
		vegetables.add(new Vegetables(12, "芽キャベツ2", "1束", 80));
		vegetables.add(new Vegetables(13, "芽キャベツ3", "1個", 30));
		vegetables.add(new Vegetables(14, "芽キャベツ4", "1kg", 550));
		vegetables.add(new Vegetables(15, "芽キャベツ5", "1kg", 630));
		vegetables.add(new Vegetables(16, "芽キャベツ6", "1kg", 410));
		vegetables.add(new Vegetables(17, "芽キャベツ7", "1kg", 312));
		vegetables.add(new Vegetables(18, "芽キャベツ8", "1kg", 520));
		vegetables.add(new Vegetables(19, "芽キャベツ9", "1kg", 633));
		vegetables.add(new Vegetables(110, "芽キャベツ10", "1kg", 610));

		model.addAttribute("vegetables",vegetables);

		List<Fruits> fruits = new ArrayList<>();
		fruits.add(new Fruits(21, "ポンカン1", "1kg", 1200));
		fruits.add(new Fruits(22, "ポンカン2", "1袋", 420));
		fruits.add(new Fruits(23, "ポンカン3", "1個", 130));
		fruits.add(new Fruits(24, "ポンカン4", "1kg", 450));
		fruits.add(new Fruits(25, "ポンカン5", "1kg", 830));
		fruits.add(new Fruits(26, "ポンカン6", "1kg", 910));
		fruits.add(new Fruits(27, "ポンカン7", "1kg", 1012));
		fruits.add(new Fruits(28, "ポンカン8", "1kg", 920));
		fruits.add(new Fruits(29, "ポンカン9", "1kg", 733));
		fruits.add(new Fruits(210, "ポンカン10", "1kg", 510));

		model.addAttribute("fruits",fruits);
		
		User user1 = new User("A店");
		model.addAttribute("user",user1);
		
		model.addAttribute(f);
		
		return "order/choice";
	}
	
	@PostMapping("confirm")
	public String confirm(OrderForm f, Model model) {
		model.addAttribute(f);
		return "order/confirm";
	}
	
	@GetMapping("cancel")
	public String cancel(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:service";
	}
	
	@PostMapping("confirmed")
	public String confirmed(RedirectAttributes redirectAttributes, OrderForm f, Model model) {
		ModelMap modelMap = new ModelMap();
		
		
		modelMap.addAttribute(f);
		redirectAttributes.addFlashAttribute("modelMap",modelMap);
		return "redirect:confirmed?complete";
	}
	
	@GetMapping("confirmed{complete}")
	public String confirmedComplete(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "order/confirmed";
	}
}
