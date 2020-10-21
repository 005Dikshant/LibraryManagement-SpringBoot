package com.comviva.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "book")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Book {
	
	
	@Id
	@Column(name = "b_id")
	private int book_id;
	
	@Column(name = "b_title")
	private String book_title;
	
	@Column(name = "b_auth")
	private String book_author;
	
	@Column(name = "b_pub")
	private String book_publisher;
	
	@Column(name = "b_genre")
	private String book_genre;
	
	@Column(name = "b_price")
	private double book_price;
	
	@Column(name = "b_qty")
	private int book_qty;
	
	@Column(name = "b_avail")
	private boolean book_isAvail;
	
	@OneToMany(mappedBy = "books_id")
	private Set<Wishlist> wishlist;
	
	@OneToMany(mappedBy = "books_id")
	private Set<BookCopy> bookCopy;
	
	public Set<Wishlist> getWishlist() {
		return wishlist;
	}
	public Set<BookCopy> getBookCopy() {
		return bookCopy;
	}
	public void setWishlist(Set<Wishlist> wishlist) {
		this.wishlist = wishlist;
	}
	public void setBookCopy(Set<BookCopy> bookCopy) {
		this.bookCopy = bookCopy;
	}
	public Book() {
		
	}
	public Book(int book_id, String book_title, String book_author, String book_publisher, String book_genre,
			double book_price, int book_qty, boolean book_isAvail) {
		super();
		this.book_id = book_id;
		this.book_title = book_title;
		this.book_author = book_author;
		this.book_publisher = book_publisher;
		this.book_genre = book_genre;
		this.book_price = book_price;
		this.book_qty = book_qty;
		this.book_isAvail = book_isAvail;
	}
	public int getBook_id() {
		return book_id;
	}
	public String getBook_title() {
		return book_title;
	}
	public String getBook_author() {
		return book_author;
	}
	public String getBook_publisher() {
		return book_publisher;
	}
	public String getBook_genre() {
		return book_genre;
	}
	public double getBook_price() {
		return book_price;
	}
	public int getBook_qty() {
		return book_qty;
	}
	public boolean isBook_isAvail() {
		return book_isAvail;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public void setBook_publisher(String book_publisher) {
		this.book_publisher = book_publisher;
	}
	public void setBook_genre(String book_genre) {
		this.book_genre = book_genre;
	}
	public void setBook_price(double book_price) {
		this.book_price = book_price;
	}
	public void setBook_qty(int book_qty) {
		this.book_qty = book_qty;
	}
	public void setBook_isAvail(boolean book_isAvail) {
		this.book_isAvail = book_isAvail;
	}
	@Override
	public String toString() {
		return book_id + " " + book_title + " " + book_author + " " + book_publisher + " " + book_genre +
				book_price + " " + book_qty + " " + book_isAvail;
	}
	
	
}
	
