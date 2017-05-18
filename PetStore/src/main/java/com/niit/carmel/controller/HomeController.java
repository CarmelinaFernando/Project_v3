package com.niit.carmel.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
 		
 		@RequestMapping("/login")
 		public String login(@RequestParam (value="error",required=false)String error,@RequestParam(value="logout",required=false)String logout,Model model){
 			if(error!=null)
 				model.addAttribute("error","Invalid Username or Password.. Please enter again");
 			if(logout!=null)
 				model.addAttribute("logout", "Logged out successfully");
 			return "login";
 			
 		}
 		
}
