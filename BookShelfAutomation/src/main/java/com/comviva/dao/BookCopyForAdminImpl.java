package com.comviva.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.comviva.entity.Book;
import com.comviva.entity.BookCopy;
import com.comviva.entity.BookCopyForAdmin;
import com.comviva.entity.Member;

@Repository("bookcopyadmindao")
@Transactional
public class BookCopyForAdminImpl implements BookCopyForAdminDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<BookCopyForAdmin> ReturnedBookList() {
		String jpql = "from BookCopyForAdmin";
		TypedQuery<BookCopyForAdmin> qry = em.createQuery(jpql,BookCopyForAdmin.class);
		List<BookCopyForAdmin> bclist = new ArrayList<>();
		bclist = qry.getResultList();
		return bclist;
	}

	@Override
	public void addReturnedBookForAdmin(int bid, int mid , LocalDate date) {
		Book book = em.find(Book.class, bid);
		Member member = em.find(Member.class, mid);
		
		String jpql = "from BookCopy where books_id=:book and member_id=:member and issueDate = :d";
		TypedQuery<BookCopy> qry1 = em.createQuery(jpql,BookCopy.class);
		qry1.setParameter("book", book);
		qry1.setParameter("member", member);
		qry1.setParameter("d", date);
		
		List<BookCopy> list = qry1.getResultList();
		BookCopy bc = list.get(0);
		
		 BookCopyForAdmin bca = new BookCopyForAdmin(bc.getSub_book_id(),bc.getItem_condition(),bc.getBooks_id(),bc.getMember_id(),bc.getIssueDate());
		 em.persist(bca);
	}

}
