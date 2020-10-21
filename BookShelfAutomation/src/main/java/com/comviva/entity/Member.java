package com.comviva.entity;

import java.time.LocalDate;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "member")
public class Member {
	
	@Id
	@Column(name="m_id")
	private int id;
	
	@Column(name="m_pass")
	private String pass;
	
	@DateTimeFormat(pattern = "yyyy-M-d")
	@Column(name="m_dob")
	private LocalDate dob;
	
	@Column(name="m_add")
	private String address;
	
	@Column(name="m_fine")
	private double fine;
	
	@Column(name = "m_email")
	private String email;
	
	//@Type(type = "com.comviva.entity.MyBooleanType")
	@Column(name="m_sus")
	private boolean suspended;
	
	
	//Blob
	@OneToMany(mappedBy = "member_id")
	private Set<Wishlist> wishlist;
	
	@OneToMany(mappedBy = "member_id")
	private Set<BookCopy> wished_books_avail;
	
//	@OneToMany(mappedBy = "dept")
//	private Set<Emp> employees;
	
	@ManyToMany()
	@JoinTable(name = "auth_user_role", joinColumns = @JoinColumn(name = "m_id"), inverseJoinColumns = @JoinColumn(name = "mem_role_id"))
	private Set<Role> roles;
	
	public Set<Wishlist> getWishlist() {
		return wishlist;
	}
	public Set<BookCopy> getWished_books_avail() {
		return wished_books_avail;
	}
	public void setWishlist(Set<Wishlist> wishlist) {
		this.wishlist = wishlist;
	}
	public void setWished_books_avail(Set<BookCopy> wished_books_avail) {
		this.wished_books_avail = wished_books_avail;
	}
	public Member() {
		
	}
	public Member(int id,String pass,LocalDate dob,String email,String address) {
		super();
		this.id = id;
		this.pass = pass;
		this.address = address;
		this.dob = dob;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public String getPass() {
		return pass;
	}
	public LocalDate getDob() {
		return dob;
	}
	public String getAddress() {
		return address;
	}
	public double getFine() {
		return fine;
	}
	public String getEmail() {
		return email;
	}
	public boolean isSuspended() {
		return suspended;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setFine(double fine) {
		this.fine = fine;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSuspended(boolean suspended) {
		this.suspended = suspended;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return id + " " + pass + " " + dob + " " + email + " " + address + " "+suspended;
	}
	
	
}
