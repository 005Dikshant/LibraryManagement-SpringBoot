package com.comviva.dao;


import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.comviva.entity.Book;
import com.comviva.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	
	@Query(value = "update Member m set "
			+ "m.pass = ?2,"
			+ "m.dob = ?3,"
			+ "m.address = ?4,"
			+ "m.fine = ?5,"
			+ "m.email = ?6,"
			+ "m.suspended = ?7  where m.id = ?1")
		public boolean update(int id , String pass,
				LocalDate dob, String address,
				double fine,String email,
				 boolean suspended);
	
	@Query(value="SELECT b from Book b WHERE b.book_id LIKE '%'||:keyword || '%' "
		    + " OR b.book_title LIKE '%'||:keyword || '%'"+"OR b.book_author LIKE '%'||:keyword || '%'"
				+" OR b.book_publisher LIKE '%'||:keyword|| '%'"
				+" OR b.book_genre LIKE '%'||:keyword|| '%'"
				+" OR b.book_price LIKE '%'||:keyword|| '%'"
				+" OR b.book_qty LIKE '%'||:keyword|| '%'")
		public List<Book>search(@Param("keyword")String keyword);
	}