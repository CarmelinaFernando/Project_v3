package com.niit.carmel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String addCustomer(@Valid @ModelAttribute(value="customer") Customer customer)
	{
		return null;
	}
	

}
