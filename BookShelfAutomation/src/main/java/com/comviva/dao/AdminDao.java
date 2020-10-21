package com.comviva.dao;

import java.time.LocalDate;
import java.util.List;

import com.comviva.entity.Book;
import com.comviva.entity.Member;

public interface AdminDao {
	
	public Book viewBookDetails(int bookId);
	public List<Book> searchBook(String exp);
	public boolean addBook(Book book);
	public boolean updateBook(Book book);
	public Member viewMember(int id);
	public void removeMember(int Id);
	public void viewHistory(int memberId);
	public void addMember(Member member);
	public int calcFine(int mid , int bid,LocalDate date);
	public List<Book> viewall();
	public boolean findMember(int id,String pass);
	public boolean removeBooks(int book_id);
	public void removeRBooks(String id);

}
