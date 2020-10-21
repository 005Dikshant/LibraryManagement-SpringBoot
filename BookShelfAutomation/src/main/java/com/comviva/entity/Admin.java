package com.comviva.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin {
	
	@Id
	@Column(name="m_id")
	private int id;
	
	@Column(name="m_pass",length=25)
	private String pass;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", pass=" + pass + "]";
	}

	protected Admin(int id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
