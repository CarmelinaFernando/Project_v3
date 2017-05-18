package com.niit.carmel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.carmel.dao.CartDAO;
import com.niit.carmel.dao.CustomerDAO;
import com.niit.carmel.model.Cart;
import com.niit.carmel.model.Customer;
import com.niit.carmel.model.Users;

@Controller
public class CartController {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private CartDAO cartDAO;
	
	@RequestMapping("/cart/getCartId")
	public String getCartId(Model model){
		
		Users users=(Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username=users.getUsername();
		Customer customer=customerDAO.getCustomerByUsername(username);
		Cart cart=customer.getCart();
		int cartId=cart.getId();
		model.addAttribute("cartId", cartId);
		return "cart";
		
	}
	
	@RequestMapping("/cart/getCart/{cartId}")
	public @ResponseBody Cart getCart(@PathVariable int cartId) {
		
		Cart cart=cartDAO.getCart(cartId);
		return cart;
	}
	
	

}
