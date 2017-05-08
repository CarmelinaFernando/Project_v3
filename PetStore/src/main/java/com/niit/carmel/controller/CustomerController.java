package com.niit.carmel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.carmel.dao.CustomerDAO;
import com.niit.carmel.model.Customer;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerDAO customerDao;
	
	public CustomerController(){
		
		System.out.println("Instantiating CustomerController");
		
	}
	
	@RequestMapping("/all/customer/addCustomer")
	public String addCustomer(@Valid @ModelAttribute(value="customer") Customer customer,BindingResult result, Model model)
	{
		if (result.hasErrors()) {
			return "signup";
		}
		try{
		customerDao.saveCustomer(customer);}
		catch(Exception e){
			
			
			System.out.println("Exception caught:" + e.getMessage());
			return "signup";
		}
		
		return "redirect:/";
	}
	

}
