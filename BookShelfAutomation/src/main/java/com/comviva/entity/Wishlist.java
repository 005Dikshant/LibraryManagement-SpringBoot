package com.comviva.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="wishlist")
public class Wishlist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int wish_list_id;
	
	@ManyToOne
	@JoinColumn(name = "book_id" , referencedColumnName = "b_id")
	private Book books_id;
	
	@ManyToOne
	@JoinColumn(name = "id" , referencedColumnName = "m_id")
	private Member member_id;
	
	public Wishlist() {
		
	}

	public Wishlist(Book books_id, Member member_id) {
		super();
		this.books_id = books_id;
		this.member_id = member_id;
	}

	public int getWish_list_id() {
		return wish_list_id;
	}

	public Book getBooks_id() {
		return books_id;
	}

	public Member getMember_id() {
		return member_id;
	}

	public void setWish_list_id(int wish_list_id) {
		this.wish_list_id = wish_list_id;
	}

	public void setBooks_id(Book books_id) {
		this.books_id = books_id;
	}

	public void setMember_id(Member member_id) {
		this.member_id = member_id;
	}
	
	
}
