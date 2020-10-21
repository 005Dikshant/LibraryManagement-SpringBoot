package com.comviva.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.comviva.dao.MemberDao;
import com.comviva.entity.Member;

@Controller
public class RegistrationController {

	@Autowired
	private MemberDao dao;
	
	
	/* To open Register page for member */
	@GetMapping("/register")
	public  String DisplayRegistartion()
	{
		return "Register";
	}
	
	/* After Register it will work for member*/
	@PostMapping("/addemp")
	public  String Adduser(@ModelAttribute("rmodel") Member member,Model model)
	{
		member.setFine(0);
		member.setSuspended(false);
		try
		{
			dao.adduser(member);
			model.addAttribute("msg", "User Added Successfully");
			model.addAttribute("rmodel", new Member()); //clearing textboxes value in view
		}catch(Exception ex)
		{
			model.addAttribute("msg", "User Not Added");
		}
		
		return "Home";
	}
}
