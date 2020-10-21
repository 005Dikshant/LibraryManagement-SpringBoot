package com.comviva.web;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import java.util.ArrayList;

//import java.util.List;

import org.springframework.ui.Model;
//import com.comviva.dao.AdminDao;
import com.comviva.dao.MemberDao;
//import com.comviva.entity.Book;

@Controller
public class LoginController {

	@Autowired
	private MemberDao dao;
	
	
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy hh.mm aa");
	String dateString = dateFormat.format(new Date()).toString();
	
	Cookie cookie,cookie1;
	
	/*
	 * @PostMapping("/login") public String
	 * ValidateLogin(@RequestParam("uid")Integer uid
	 * , @RequestParam("password")String pass , Model model ) { boolean bt =
	 * dao.validation(uid, pass); if(bt==false) { model.addAttribute("msg",
	 * "Invalid"); return "Home"; } else {
	 * 
	 * return "Welcome"; //List<Book> list =new ArrayList<>(); //list =
	 * adao.viewall(); //model.addAttribute("blist",list); //return "AdminPage"; } }
	 */
	
	// member login
	@PostMapping("/login")
	public String ValidateLogin(@RequestParam("uid") int id,
			@RequestParam("password") String pass,
			@RequestParam("txtname") String name,
			Model model,
			HttpServletResponse res) {
		
		if(dao.findMember(id,pass)) {
			model.addAttribute("msg","Welcome "+name+" ,"+dateString);
		}else {
			model.addAttribute("msg","Invalid Member");
			return "Home";
		}
		
		cookie = new Cookie("name",name);
		cookie1 = new Cookie("memberId",String.valueOf(id));
		res.addCookie(cookie);
		res.addCookie(cookie1);
		return dao.getRedirection(id);
	}
	
	//member logout
	@GetMapping("/signout")
	public String signOut(HttpServletResponse res,Model model) {
		
		cookie.setMaxAge(0);
		res.addCookie(cookie);
		
		cookie1.setMaxAge(0);
		res.addCookie(cookie1);
		model.addAttribute("msg","Successfully Logout");
		
		return "Home";
	}
	
}
