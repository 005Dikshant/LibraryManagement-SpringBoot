package com.comviva.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.comviva.entity.Book;
import com.comviva.entity.BookCopy;
import com.comviva.entity.Member;
@Repository("bookcopydao")
@Transactional
public class BookCopyDaoImpl implements BookCopyDao {

	@PersistenceContext
	private EntityManager em;
	@Override
	public BookCopy find(int mid, int bid,LocalDate date) {
		Book book = em.find(Book.class, bid);
		Member member = em.find(Member.class, mid);
		String jpql = "from BookCopy where books_id=:book and member_id=:member and issueDate=:d";
		TypedQuery<BookCopy> qry = em.createQuery(jpql,BookCopy.class);
		qry.setParameter("book", book);
		qry.setParameter("member", member);
		qry.setParameter("d", date);
		List<BookCopy> blist = qry.getResultList();
		return blist.size()>0?blist.get(0):new BookCopy();
	}
	@Override
	public List<BookCopy> issueBookList() {
		String jpql = "from BookCopy";
		TypedQuery<BookCopy> qry = em.createQuery(jpql,BookCopy.class);
		List<BookCopy> bclist = new ArrayList<>();
		bclist = qry.getResultList();
		return bclist;
	}

}
