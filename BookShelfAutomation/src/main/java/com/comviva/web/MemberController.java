package com.comviva.web;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.comviva.dao.AdminDao;
import com.comviva.dao.IMemDao;
import com.comviva.dao.MemberDao;
import com.comviva.entity.Book;
import com.comviva.entity.BookCopy;
import com.comviva.entity.BookCopyForAdmin;
import com.comviva.entity.Member;
import com.comviva.entity.Wishlist;

@Controller
public class MemberController {
	
	@Autowired
	private IMemDao dao;
	
	@Autowired
	private AdminDao adao;
	
	@Autowired
	private MemberDao mdao;
	
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy hh.mm aa");
	String dateString = dateFormat.format(new Date()).toString();
	
	/*when to click home for member */
	@GetMapping("/homi")
	public String HomePage() {
		return "Welcome";
	}
	
	
	/*for issue button in member */
	@GetMapping("/issue")
	public String IssueBookForm(@RequestParam("id")int bid,@CookieValue(value = "name",defaultValue = "Atta") String username,
			@CookieValue(value="memberId",defaultValue="1001")String mid,
			Model model) {
		boolean bt = dao.isbookqty0(bid);
		if(bt==true)
		{	model.addAttribute("msg","Book Is Unavailable");
		return "forward:/displaybookform";
		}
			model.addAttribute("bid",bid);
			model.addAttribute("mid",Integer.parseInt(mid));
			model.addAttribute("date",LocalDate.now());
		return "forward:/displayissuebook";
		
		//forward:prefix ultimately does a RequestDispatcher.forward instead of the 
		//redirect:prefix
				
	}
	
	
	/* to open search book form from nav link for members*/
	// SEARCH BOOK
	@GetMapping("/displaysearchbook")
	public String displaySearchBook(@CookieValue(value = "name",defaultValue = "Atta") String username,
			Model model) {
		model.addAttribute("username","Welcome "+username+", "+dateString);
		return "SearchBookForm";
	}
	
	
	/* on clicking search button on search book form */
	@PostMapping("/searchbook")
	public String detailsForBookSearched(@RequestParam("txttitle") String title ,
			@RequestParam("txtauthor") String author,
			@RequestParam("txtgenre") String genre,
			@RequestParam("txtpublisher") String publisher,
			@CookieValue(value = "name",defaultValue = "Atta") String username,
			Model model) {
		List<Book> blist = dao.searchBook(title, author, genre, publisher);
		model.addAttribute("username","Welcome "+username+", "+dateString);
		model.addAttribute("blist",blist);
		
		return "MemberBookView";
	}
	
	
	/* to display the issue book form from nav link of member */
	// ISSUE BOOK
	@GetMapping("/displayissuebook")
	public String displayIssueBook(@CookieValue(value = "name",defaultValue = "Atta") String username,
			Model model) {
		model.addAttribute("username","Welcome "+username+", "+dateString);
		return "IssueBookForm";
	}
	
	
	/* after clicking issue button from issue book form */
	//@ModelAttribute("emodel") Emp emp
	@PostMapping("/issuebook")
	public String detailsForIssueBook(@RequestParam("txtid") String id,
			@RequestParam("txtbid") int bid,
			@RequestParam("txtmid") int mid,
			@RequestParam("txtdate") String date,
			@RequestParam("txtcond") String cond,
			@CookieValue(value = "name",defaultValue = "Atta") String username,
			Model model) {
		
		LocalDate localdate = LocalDate.parse(date);
		boolean bt = dao.isbookqty0(bid);
		if(bt==true)
		{	model.addAttribute("msg","Book Is Unavailable");
		return "IssueBookForm";
		}
		boolean issued = dao.issueBook(bid, mid, localdate, cond, id);
		if(issued == false) {
			model.addAttribute("error", "A VALUE ALREADY EXIST FOR ENTRY RECORD");
		}else {
			model.addAttribute("msg","Book Issued");
		}
		model.addAttribute("username","Welcome "+username+", "+dateString);
		return "IssueBookForm";
	}
	
	/*
	 * @GetMapping("/issue") public String butttonIssueBook(@RequestParam("id") int
	 * bid,
	 * 
	 * @CookieValue(value = "name",defaultValue = "Atta") String username, Model
	 * model) {
	 * 
	 * 
	 * boolean issued = dao.issueBooks(bid); if(issued == false) {
	 * model.addAttribute("msg","Book Is Unavailable"); }else {
	 * model.addAttribute("msg","Book Issued"); }
	 * model.addAttribute("username","Welcome "+username+", "+dateString); return
	 * "MemberBookView"; }
	 */
	
	
	


	/* after click issue book view on the nav for members show issued books */
	@GetMapping("/issuebookview")
	public String issueBookView(@CookieValue(value = "name",defaultValue = "Atta") String username,
			@CookieValue(value = "memberId",defaultValue = "Atta") String memberId,
			Model model) {
		List<BookCopy> bookcopylist = dao.issueBookList();
		List<BookCopy> bclist = new ArrayList<>();
		int mid = Integer.parseInt(memberId);
		for(BookCopy bc : bookcopylist) {
			if(mid == bc.getMember_id().getId()) {
				bclist.add(bc);
			}
		}
		model.addAttribute("username","Welcome "+username+", "+dateString);
		if(bclist.size() == 0) {
			model.addAttribute("msg","No Books Issued");
		}else {
			model.addAttribute("bclist",bclist);
		}	
		return "IssueBookView";
		
		
	}
	
	//VIEW BOOK
	@GetMapping("/displaybookform")
	public String displayBookForm(@CookieValue(value = "name",defaultValue = "Atta") String username,Model model)
	{
		model.addAttribute("username","Welcome "+username+", "+dateString);
		List<Book> list =new ArrayList<>();
		list = adao.viewall();
	  model.addAttribute("blist",list);
	  return "MemberBookView";
	}
	
	
	@PostMapping("/bookdetails")
	public String bookDetails(@RequestParam("txtid") int b_id, 
			@CookieValue(value = "name",defaultValue = "Atta") String username,
			Model model) {
		model.addAttribute("username","Welcome "+username+", "+dateString);
		try {
			Book book = dao.viewBook(b_id);
			List<Book> blist = new ArrayList<>();
			blist.add(book);
			model.addAttribute("blist",blist);
		}catch(Exception ex) {
			model.addAttribute("msg","Invalid Book Id");
		}
		return "MemberBookView";
	} 
	
	
	//VIEW PROFLIE
	@GetMapping("/displayprofile")
	public String displayprofile(@CookieValue(value="memberId",defaultValue="1001")String mid,
			@CookieValue(value = "name",defaultValue = "Atta") String username,Model model) {
		model.addAttribute("username","Welcome "+username+", "+dateString);
	//	return "MemberProfile";
		Member member= dao.viewProfile(Integer.parseInt(mid));
		 List<Member> mlist = new ArrayList<>();
		 mlist.add(member);
		 model.addAttribute("mlist",mlist);
		 return "MemberView";
		
	} 
   // to show us member profile details in members
//	@PostMapping("/memberdetails")
//	public String memberDetails( 
//			@CookieValue(value = "name",defaultValue = "Atta") String username,
//			@CookieValue(value="memberId",defaultValue="1001")String mid,
//			Model model) 
//	{  model.addAttribute("username","Welcome "+username+", "+dateString);
//		    Member member= dao.viewProfile(m_id);
//			List<Member> mlist = new ArrayList<>();
//			mlist.add(member);
//			if(mlist.size()>0)
//			{
//			model.addAttribute("mlist",mlist);
//			return "MemberView";
//			}
//			else
//			{
//				model.addAttribute("msg","Invalid Member Id");
//				return "MemberProfile";
//			}
//			 
//			
//	}
	//RETURN BOOK
	@GetMapping("/displayreturnbook")
	public String displayReturnBook(@CookieValue(value = "name",defaultValue = "Atta") String username,
			Model model) {
		model.addAttribute("username","Welcome "+username+", "+dateString);
		return "ReturnBookForm";
	}
	
	// after clicking return book button in return book form
	@GetMapping("/return")
	public String returnBook(@RequestParam("id") int bid,
		@RequestParam("mid") int mid,
		@RequestParam("date") String d,
		@CookieValue(value = "name",defaultValue = "Atta") String username,
		@CookieValue(value = "memberId",defaultValue = "Atta") String memberId,
		Model model) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
		LocalDate date = LocalDate.parse(d, formatter);
		System.out.println(date);
		model.addAttribute("username",username);
		if(!String.valueOf(mid).equals(memberId)) {
			model.addAttribute("msg","Invalid Credentials");
		}else {	
			
			int t = adao.calcFine(mid,bid,date);
			model.addAttribute("fine","the fine you have to pay is Rs. " + t);
			System.out.println(t);
			
			dao.addReturnedBookForAdmin(bid, mid, date);
			dao.returnBook(bid, mid , date);
			model.addAttribute("msg","Book Returned.");
		}			
		return "Welcome";
	}
	
	
	
	/*
	 * @GetMapping("/return") public String
	 * ReturnForm(@RequestParam("sub_book_id")int bid,Model model) {try {
	 * dao.returnBook(bid); model.addAttribute("msg","Book Returned.");
	 * }catch(Exception ex) { model.addAttribute("msg","Invalid Credentials"); }
	 * return "Welcome"; }
	 */
	
	//WISHLIST
	/*
	 * @GetMapping("/displaywishlistform") public String
	 * displayWishlistForm(@CookieValue(value = "name",defaultValue = "Atta") String
	 * username, Model model) {
	 * model.addAttribute("username","Welcome "+username+", "+dateString); return
	 * "WishlistForm"; }
	 */
	 
	// wishlist
	  @GetMapping("/displaywishlist") public String
	  displayWishlist(@CookieValue(value = "name",defaultValue = "Atta") String
	 username,
	 @CookieValue(value="memberId",defaultValue="1001")String uid,
	 Model model) {
	 model.addAttribute("username","Welcome "+username+", "+dateString);
	 List<Wishlist> list = dao.wishlistView(); 
	 List<Wishlist> wlist = new ArrayList<>();
	 if(list.size() == 0) {
	 model.addAttribute("msg","Empty WishList"); }
	 else {
		 for(int i = 0;i<list.size();i++)
		 {
			 if(list.get(i).getMember_id().getId()==Integer.parseInt(uid))
				 wlist.add(list.get(i));
		 }
	 model.addAttribute("wlist",wlist); 
	 }
	 return "ViewWishList"; }
	 
	
	// will add into wishlist
	@GetMapping("/wishlist")
	public String wishList(@RequestParam("id") int bid,
			@CookieValue(value="memberId",defaultValue="1001")String uid,
			@CookieValue(value = "name",defaultValue = "Atta") String username,
		
			Model model) {
		try {
			dao.wishlist(bid, Integer.parseInt(uid));
			model.addAttribute("msg","Added Into Wishlist");
			System.out.println(uid);
		}catch(Exception ex) {
			model.addAttribute("msg","Invalid ");
		}
		return "forward:/displaybookform";
	}
	
	@GetMapping("/returned")
	public String displayReturnedlist(Model model) {
		List<BookCopyForAdmin> bclist = dao.ReturnedBookList();
		if(bclist.size() == 0) {
			model.addAttribute("msg","Empty ");
		}else {
			model.addAttribute("bclist",bclist);
		}
		return "ReturnedBookViewForAdmin";
	}
	
	//edit member form
	@GetMapping("/editing")
	public String EditMForm(@RequestParam("id")int mid,Model model)
	{
		Member mem = dao.viewMDetails(mid);
		model.addAttribute("Member",mem);
		return "EditMForm";
	}
	
	//update member form
	@PostMapping("/updating")
	public String UpdateForm(@ModelAttribute("rmodel")Member mem , Model model)
	{
		try
		{
			dao.updateBook(mem);
			model.addAttribute("msg", "Member Updated Successfully");
			return "redirect:/adminmemberhome";
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			model.addAttribute("Member",mem);
			model.addAttribute("msg", "Book Not Updated");
		}
		
		return "EditForm";
	}
	
	//to show all details of members in admin
	@GetMapping("/adminmemberhome")
	public String AdminMemberHome(Model model)
	{
		List<Member> list =new ArrayList<>();
		list = mdao.viewall();
	  model.addAttribute("blist",list);
	  return "AdminMemberDetails";
	}
	
	//to delete members in admin
	@GetMapping("/deleting")
	public String DeleteForm(@RequestParam("id")int mid,Model model)
	{
		adao.removeMember(mid);
		model.addAttribute("msg", "Deleted Succesfully");
		return "redirect:/adminmemberhome";
	}
	
	// to search members 
	@GetMapping("/searchMem")
	public String searchResults(@RequestParam("searchbooks")String exp,Model model)
	{
		List<Book> search_result = new ArrayList<>();
		search_result = adao.searchBook(exp);
		if(search_result.size()>0) {
		model.addAttribute("blist", search_result);
		return "MemberBookView";
		}
		else
		{
			model.addAttribute("msg", "No Record Found");
			List<Book> list =new ArrayList<>();
			list = adao.viewall();
		    model.addAttribute("blist",list);
		  return "MemberBookView";
		}
	}
	
	//delete wishlist
	@GetMapping("/deletes")
	public String DeleteWishForm(@RequestParam("id")int wid,Model model)
	{
		dao.removeWishBook(wid);
		model.addAttribute("msg", "Deleted Succesfully");
		return "redirect:/displaywishlist";
	}
	
	// for admin issue book view for admin
	@GetMapping("/issuebookadmin")
	public String issueBookViewForAdmin(Model model) {
		List<BookCopy> bclist = dao.issueBookList();
		if(bclist.size() == 0) {
			model.addAttribute("msg","No Books Issued");
		}else {
			model.addAttribute("bclist",bclist);
		}	
		return "IssueBookViewForAdmin";
	}
	
}
