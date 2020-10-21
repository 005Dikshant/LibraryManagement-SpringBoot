package com.comviva.web;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.comviva.dao.AdminDao;
import com.comviva.entity.Book;
import com.comviva.entity.Member;


@Controller
public class BookController {

	@Autowired
	private AdminDao dao;
	
	
	//to get to adminpage
	@GetMapping("/adminpage")
	public String viewAdminPage(Model model)
	{
		List<Book> list =new ArrayList<>();
		list = dao.viewall();
	  model.addAttribute("blist",list);
	  return "AdminPage";
	}
	
	@GetMapping("/add")
	public String redirecttoaddbookform()
	{
		return "AddBook";
	}
	
	//admin addbookss
	@PostMapping("/addbook")
	public String AddBookToDb(@ModelAttribute("bmodel")Book book  , Model model)
	{
		try
		{
			dao.addBook(book);
			model.addAttribute("msg", "Book Added Successfully");
			model.addAttribute("bmodel", new Book()); //clearing textboxes value in view
		}catch(Exception ex)
		{
			model.addAttribute("msg", "Book Not Added");
		}
		
		return "AddBook";
	}
	
	//admin edit books
	@GetMapping("/edit")
	public String EditForm(@RequestParam("id")int bid,Model model)
	{
		Book book = dao.viewBookDetails(bid);
		model.addAttribute("book", book);
		return "EditForm";
	}
	
	
	// admin delete books
	@GetMapping("/delete")
	public String DeleteForm(@RequestParam("id")int bid,Model model)
	{
		boolean bt = dao.removeBooks(bid);
		if(bt==true)
		model.addAttribute("msg", "Deleted Succesfully");
		else
			model.addAttribute("msg", "USER HAS ISSUED THE BOOK ");	
		return "forward:/adminpage";
	}
	
	// admin update books
	@PostMapping("/update")
	public String UpdateForm(@ModelAttribute("bmodel")Book book , Model model)
	{
		try
		{
			dao.updateBook(book);
			model.addAttribute("msg", "Book Updated Successfully");
			return "redirect:/adminpage";
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			model.addAttribute("book",book);
			model.addAttribute("msg", "Book Not Updated");
		}
		
		return "EditForm";
	}
	
	//admin search books
	@GetMapping("/search")
	public String searchResult(@RequestParam("searchbook")String exp,Model model)
	{
		List<Book> search_result = new ArrayList<>();
		search_result = dao.searchBook(exp);
		if(search_result.size()>0) {
		model.addAttribute("blist", search_result);
		return "AdminPage";
		}
		else
		{
			model.addAttribute("msg", "No Record Found");
			List<Book> list =new ArrayList<>();
			list = dao.viewall();
		    model.addAttribute("blist",list);
		  return "AdminPage";
		}
	}
	
	@GetMapping("/deletesR")
	public String DeleteReturned(@RequestParam("id")String bid,Model model)
	{
		
		dao.removeRBooks(bid);
		model.addAttribute("msg", "Deleted Succesfully");
		return "redirect:/returned";
	}
}
