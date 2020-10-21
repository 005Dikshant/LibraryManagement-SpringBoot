package com.comviva.dao;

import java.time.LocalDate;
import java.util.List;

import com.comviva.entity.BookCopy;

public interface BookCopyDao {

	public BookCopy find(int mid , int bid,LocalDate date);
	public List<BookCopy> issueBookList();
}
