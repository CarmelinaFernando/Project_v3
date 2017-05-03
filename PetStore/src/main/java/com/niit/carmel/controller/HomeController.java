package com.niit.carmel.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@Autowired
	SessionFactory sessionFactory;
	public HomeController() {
		System.out.println("Instantiating home controller");
	}
 		@RequestMapping("/") 
 		public String home(){
 			
 			return "index";
 		}
 		
 		@RequestMapping("/all/about")
 		public String about(){
 			
 			return "aboutUs";
 		}
 		
 		@RequestMapping("/all/contact")
 		public String contact(){
 			
 			return "contactUs";
 		}
 		
 		@RequestMapping("/all/product")
 		public String product(){
 			
 			return " ";
 		}
 		
 		@RequestMapping("/all/category")
 		public String category(){
 			
 			return " ";
 		}
 		
}
