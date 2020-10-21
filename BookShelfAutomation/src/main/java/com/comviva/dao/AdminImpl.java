package com.comviva.dao;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.comviva.entity.Admin;
import com.comviva.entity.Book;
import com.comviva.entity.BookCopy;
import com.comviva.entity.BookCopyForAdmin;
import com.comviva.entity.Member;
import com.comviva.entity.Wishlist;


@Repository("admindao")
@Transactional
public class AdminImpl implements AdminDao {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private BookRepository bk;
	
	@Autowired
	private MemberDao mdao;
	
	@Autowired
	private BookCopyDao bdao;
	
	@Autowired
	private IMemDao idao;
	
	
	@Override
	public Book viewBookDetails(int bookId) {
		// TODO Auto-generated method stub
		Book book = em.find(Book.class, bookId); 
		return book;
	}
	
	

	@Override
	public List<Book> searchBook(String exp) {
		// TODO Auto-generated method stub
		
		return bk.search(exp);
	}

	@Override
	public boolean addBook(Book book) {
		em.persist(book);
		return true;
		
	}

	@Override
	public boolean removeBooks(int book_id) {
		Book book = em.find(Book.class, book_id);
		if(book.getBook_qty()>1)
		{
			book.setBook_qty(book.getBook_qty()-1);
			return true;
		}
		else
		{
			List<BookCopy> list = new ArrayList<>();
			list = idao.issueBookList();
			boolean bt = false;
			for(int i = 0;i<list.size();i++)
			{
				if(list.get(i).getBooks_id().getBook_id()==book_id)
				{
					bt = true;
					return false;
				}
					
			}
				em.remove(book);
				return true;
		}
		}

	@Override
	public void removeRBooks(String sub_book_id) {
		BookCopyForAdmin book = em.find(BookCopyForAdmin.class, sub_book_id);
		
		em.remove(book);
	}
	@Override
	public Member viewMember(int id) {
		Member me = em.find(Member.class, id);
		return me;
	}

	@Override
	public void removeMember(int id) {
		Member me = em.find(Member.class, id);
		removeWishlist(id);
		removeissuedBooks(id);
		removeReturned_List(id);
		em.remove(me);
	}
	
	public void removeWishlist(int id)
	{
		List<Wishlist> list = new ArrayList<>();
		list = idao.wishlistView();
		if(list.size()!=0) 
		               {
		for(int i = 0;i<list.size();i++)
		{
			if(list.get(i).getMember_id().getId()==id)
			{
				idao.removeWishBook(list.get(i).getWish_list_id());
			}
		}
		                 }
	}
	
	public void removeissuedBooks(int id)
	{
		List<BookCopy> list = new ArrayList<>();
		list = idao.issueBookList();
		if(list.size()!=0) {
		for(int i = 0;i<list.size();i++)
		{
			if(list.get(i).getMember_id().getId()==id)
			{
				idao.returnBook(list.get(i).getBooks_id().getBook_id(), id, list.get(i).getIssueDate());
			}
		}	                  
		                 }
	}
	
	public void removeReturned_List(int id)
	{
		List<BookCopyForAdmin> bclist = idao.ReturnedBookList();
		for(int i = 0;i<bclist.size();i++)
		{
			if(bclist.get(i).getMember_id().getId()==id)
			{
				removeRBooks(bclist.get(i).getSub_book_id());
			}
		}
	}
	
	@Override
	public void viewHistory(int memberId) {
		
	}
	@Override
	public int calcFine(int mid,int bid,LocalDate date) {
		LocalDate lt  = LocalDate.now();
		BookCopy book = bdao.find(mid, bid,date);
		LocalDate id = book.getIssueDate();
		System.out.println(lt + " " + id);
		//Duration duration = Duration.between(lt, id);
		//long days = duration.toDays();
		 Period period = Period.between(id, lt);
		 int days = period.getDays();
		System.out.println(days);
		int fine = days>7?(days-7)*10:0;
		Member member = em.find(Member.class, mid);
		member.setFine(member.getFine()+(int)fine);
		//em.merge(member);
		return fine;
	}
	

	@Override
	public void addMember(Member member) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Book> viewall() {
		String jpql = "from Book";
		TypedQuery<Book> qry = em.createQuery(jpql , Book.class);
		return qry.getResultList();
	}

	@Override
	public boolean updateBook(Book book) {
//		book.setBook_author(book.getBook_author());
//		book.setBook_genre(book.getBook_genre());
//		book.setBook_id(book.getBook_id());
//		book.setBook_isAvail(book.isBook_isAvail());
//		book.setBook_price(book.getBook_price());
//		book.setBook_publisher(book.getBook_publisher());
//		book.setBook_qty(book.getBook_qty());
//		book.setBook_title(book.getBook_title());
//		em.getTransaction().commit();
		bk.save(book);
		return true;
	}
	@Override
	public boolean findMember(int id,String pass) {
		Admin mem = em.find(Admin.class, id);
		if(mem != null) {
			if(mem.getPass().equals(pass)) {
				return true;
			}
		}
		return false;
		
	}


}
