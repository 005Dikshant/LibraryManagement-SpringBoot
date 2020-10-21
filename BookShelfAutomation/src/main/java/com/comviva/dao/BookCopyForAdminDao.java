package com.comviva.dao;

import java.time.LocalDate;
import java.util.List;

import com.comviva.entity.BookCopyForAdmin;

public interface BookCopyForAdminDao {
	public List<BookCopyForAdmin> ReturnedBookList();
	public void addReturnedBookForAdmin(int bid, int mid,LocalDate date);
}
