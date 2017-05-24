package com.niit.carmel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
	
	public LoginController()
	{
		System.out.println("Instantiating Login Controller");
	}
	
	/*@RequestMapping("/login")
	public String showLoginpage()
	{
		return "login";
	}
	@SuppressWarnings("unchecked")
	@RequestMapping("/login_session_attributes")
	public String checkLogin(HttpSession session,Model model)
	{
		String username=SecurityContextHolder.getContext().getAuthentication().getName();
		Collection<GrantedAuthority> authorities=(Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		System.out.println("User Name:"+username);
		session.setAttribute("username", username);
		
		String role="USER_ROLE";
		String page=" ";
		session.setAttribute("LoggedIn", true);
		for(GrantedAuthority authority : authorities)
		{
			System.out.println(authority.getAuthority());
			 if(authority.getAuthority().equals(role))
			 {
				 page="successPage";
				 
			 }
			 else
			 {
				 page="index";
			 }
		}
		return page;
	}
	*/
	
	@RequestMapping("/login")
	public String login(@RequestParam (value="error",required=false)String error,@RequestParam(value="logout",required=false)String logout,Model model){	
		if(error!=null)
		model.addAttribute("error","Invalid username or password... Please enter the correct username and password");
		if(logout!=null)
			model.addAttribute("logout", "logout successfully");
		
		return "login";
	}
	
	
	
	

}
