package com.gcu.controllers;

import java.util.List;

import javax.validation.Valid;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.models.LoginModel;
import com.gcu.models.OrderModel;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping("/")
	public String displayLoginForm(Model model) {
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		
		return "loginForm.html";
	}
	
	@PostMapping("/processLogin")
	public String processLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("loginMode", loginModel);
		}
		
		model.addAttribute("loginModel", loginModel);
		
		return "loginResults.html";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@ModelAttribute("loginModel") @Valid LoginModel loginModel,
	                      BindingResult bindingResult, Model model) {
	    if (bindingResult.hasErrors()) {
	        return "login";
	    }

	    List<OrderModel> orders = createOrders(); // Implement this method to create orders

	    model.addAttribute("title", "My Orders");
	    model.addAttribute("orders", orders);

	    return "orders";
	}

	private List<OrderModel> createOrders() {
	    List<OrderModel> orders = new ArrayList<>();

	    OrderModel order1 = new OrderModel(1L, "ORD-001", "Product A", 10.99f, 2);
	    OrderModel order2 = new OrderModel(2L, "ORD-002", "Product B", 19.99f, 1);
	    OrderModel order3 = new OrderModel(3L, "ORD-003", "Product C", 5.99f, 3);

	    orders.add(order1);
	    orders.add(order2);
	    orders.add(order3);

	    return orders;
	}
	
    @GetMapping("/orders")
    public String showOrders(Model model) {
        List<OrderModel> orders = createOrders(); // Implement this method to create orders

        model.addAttribute("title", "My Orders");
        model.addAttribute("orders", orders);

        return "orders";
    }
	
	
}