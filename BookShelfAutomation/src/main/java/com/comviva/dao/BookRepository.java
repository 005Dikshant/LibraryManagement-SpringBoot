package com.comviva.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.comviva.entity.Book;

public interface BookRepository extends JpaRepository<Book	, Integer> {
	@Query(value="SELECT b from Book b WHERE b.book_id LIKE '%'||:keyword || '%' "
		    + " OR b.book_title LIKE '%'||:keyword || '%'"+"OR b.book_author LIKE '%'||:keyword || '%'"
				+" OR b.book_publisher LIKE '%'||:keyword|| '%'"
				+" OR b.book_genre LIKE '%'||:keyword|| '%'"
				+" OR b.book_price LIKE '%'||:keyword|| '%'"
				+" OR b.book_qty LIKE '%'||:keyword|| '%'")
		public List<Book>search(@Param("keyword")String keyword);

@Query(value = "update Book b set "
		+ "b.book_title = ?2,"
		+ "b.book_author = ?3,"
		+ "b.book_publisher = ?4,"
		+ "b.book_genre = ?5,"
		+ "b.book_price = ?6,"
		+ "b.book_qty = ?7,"
		+ "b.book_isAvail = ?8 where b.book_id = ?1")
	public boolean update(int book_id , String book_title,
			String book_author, String book_publisher,
			String book_genre,double book_price,int book_qty,
			 boolean book_isAvail);
}
