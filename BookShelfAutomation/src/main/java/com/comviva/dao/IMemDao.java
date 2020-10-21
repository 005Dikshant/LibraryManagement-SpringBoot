package com.comviva.dao;

import java.time.LocalDate;
import java.util.List;

import com.comviva.entity.Book;
import com.comviva.entity.BookCopy;
import com.comviva.entity.BookCopyForAdmin;
import com.comviva.entity.Member;
import com.comviva.entity.Wishlist;

public interface IMemDao {
	
	public boolean issueBook(int bid,int mid,LocalDate issueDate,String condition,String id);
	public Book viewBook(int b_id);
	public List<Book> searchBook(String title,String author,String genre,String publisher);
	public Member viewMember(Member member);
	public boolean wishlist(int bid,int mid);
	public void viewHistory(int mid);
	public Member viewProfile(int id);
	public List<BookCopy> issueBookList();
	public List<Wishlist> wishlistView();
	public Member viewMDetails(int Id);
	public void addReturnedBookForAdmin(int bid,int mid,LocalDate date);
	public List<BookCopyForAdmin> ReturnedBookList();
	public boolean updateBook(Member mem);
	public void removeWishBook(int wish_list_id);
	public void returnBook(int bid,int mid,LocalDate date);
	public boolean isbookqty0(int bid);
	

	
	
	
	
	
}
