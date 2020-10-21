package com.comviva.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
   // very first page to open login
	@GetMapping({"/","/home","/login"})
	public static String displayHomePage(@CookieValue(value = "name",defaultValue = "Atta") String username,
			Model model) {
		if(username.equals("Atta")) {
			return "Home";
		}	
		else {
			System.out.println("Value of Username "+username);
			return "Welcome";
		}
	}
	
	
	
}
