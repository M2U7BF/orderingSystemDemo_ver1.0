package com.example.ordering.controller;

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

import com.example.ordering.domain.entity.User;
import com.example.ordering.domain.service.OrderServiceImpl;
import com.example.ordering.form.OrderForm;

@Controller
@RequestMapping("/order")
@SessionAttributes(value = "")
public class OrderController {
	
	private final OrderServiceImpl orderService = new OrderServiceImpl();
	
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

		model.addAttribute("vegetables", orderService.findAll());
		model.addAttribute("fruits",orderService.findAll());
		
		User user1 = new User("A店");
		model.addAttribute("user",user1);
		
		model.addAttribute(f);
		
		return "order/choice";
	}

	@PostMapping("choice{correct}")
	public String CorrectChoice(OrderForm f, Model model) {

		model.addAttribute("vegetables", orderService.findAll());
		model.addAttribute("fruits",orderService.findAll());
		
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
		orderService.insertOrder(f);
		
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
