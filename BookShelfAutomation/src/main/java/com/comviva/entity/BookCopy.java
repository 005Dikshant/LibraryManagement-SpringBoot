package com.comviva.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="bookcopy")
@DynamicInsert(true)
@DynamicUpdate(true)
public class BookCopy {

	@Id
	private String sub_book_id;
	
	private String item_condition;
	
	@ManyToOne
	@JoinColumn(name = "book_id" , referencedColumnName = "b_id")
	private Book books_id;
	
	@ManyToOne
	@JoinColumn(name = "id" , referencedColumnName = "m_id")
	private Member member_id;
	
	@DateTimeFormat(pattern = "yyyy-M-d")
	private LocalDate issueDate;

public BookCopy() {
		
	}

public BookCopy(String sub_book_id, String item_condition, Book books_id, Member member_id, LocalDate issueDate) {
	super();
	this.sub_book_id = sub_book_id;
	this.item_condition = item_condition;
	this.books_id = books_id;
	this.member_id = member_id;
	this.issueDate = issueDate;
}



	public BookCopy(int books_id) {
		// TODO Auto-generated constructor stub
	}

	public String getSub_book_id() {
		return sub_book_id;
	}

	public String getItem_condition() {
		return item_condition;
	}

	public Book getBooks_id() {
		return books_id;
	}

	public Member getMember_id() {
		return member_id;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setSub_book_id(String sub_book_id) {
		this.sub_book_id = sub_book_id;
	}

	public void setItem_condition(String item_condition) {
		this.item_condition = item_condition;
	}

	public void setBooks_id(Book books_id) {
		this.books_id = books_id;
	}

	public void setMember_id(Member member_id) {
		this.member_id = member_id;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}
	
	
	
}
