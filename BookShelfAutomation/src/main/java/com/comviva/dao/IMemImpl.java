package com.comviva.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.comviva.entity.Book;
import com.comviva.entity.BookCopy;
import com.comviva.entity.BookCopyForAdmin;
import com.comviva.entity.Member;
import com.comviva.entity.Wishlist;

@Repository("memdao")
@Transactional
public class IMemImpl implements IMemDao {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private MemberRepository bk;
	
	@Autowired
	private BookCopyDao bdao;
	
	@Autowired
	private BookCopyForAdminDao bookcopyadmindao;
	


	@Override
	public List<Book> searchBook(String title, String author, String genre, String publisher) {
		String jpql = "from Book where book_title=:title and book_author=:author and book_genre=:genre"
				+ " and book_publisher=:publisher";
		
		TypedQuery<Book> qry = em.createQuery(jpql,Book.class);
		qry.setParameter("title", title);
		qry.setParameter("author", author);
		qry.setParameter("genre", genre);
		qry.setParameter("publisher", publisher);
		
		return qry.getResultList();
	}
	@Override
	public Book viewBook(int b_id) {
		Book book = em.find(Book.class,b_id);
		return book;
	}

	@Override
	public Member viewMDetails(int Id) {
		// TODO Auto-generated method stub
		Member mem = em.find(Member.class,Id); 
		return mem;
	}

	@Override
	public boolean issueBook(int bid,int mid,LocalDate issueDate,String condition,String id) {
		Book book = em.find(Book.class, bid);
		Member member = em.find(Member.class,mid);
		BookCopy duplicateValue = em.find(BookCopy.class, id);
		if(duplicateValue ==null) {
			int qty = book.getBook_qty();
			if(qty <= 0) {
				book.setBook_isAvail(false);
				return false;
			}else {
				book.setBook_qty(qty-1);
			}
		BookCopy bc = new BookCopy(id,condition,book,member,issueDate);
		em.persist(bc);
		return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public void returnBook(int bid, int mid,LocalDate date) {
		// TODO Auto-generated method stub
		Book book = em.find(Book.class, bid);
		int qty = book.getBook_qty();
		book.setBook_qty(qty+1);
		if(book.isBook_isAvail() == false)
		{
			book.setBook_isAvail(true);
		}
		BookCopy bc = bdao.find(mid, bid,date);
		em.remove(bc);
	}
	

	@Override
	public Member viewProfile(int id) {
		Member mem = em.find(Member.class, id);
		System.out.println("Member " + mem.getId());
		return mem;
	}

	@Override
	public Member viewMember(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean wishlist(int bid, int mid) {
		
		Book book = em.find(Book.class, bid);
		Member member = em.find(Member.class, mid);
		
		Wishlist wishlist = new Wishlist(book, member);
		try{
			em.persist(wishlist);
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	
	@Override
	public void viewHistory(int mid) {
		// TODO Auto-generated method stub
		String jpql = "from Wishlist w inner join fetch w.member_id m where m.id=:mid";
		TypedQuery<Wishlist> qry = em.createQuery(jpql,Wishlist.class);
		qry.setParameter("mid", mid);
		List<Wishlist> wlist = qry.getResultList();
		
		for(Wishlist w: wlist) {
			System.out.println(w.getWish_list_id());
			System.out.println(w.getMember_id());
			System.out.println("---------------------------------------------------------------");
		}
	}

	@Override
	public List<BookCopy> issueBookList() {
		return bdao.issueBookList();
	}
	
	@Override
	public List<Wishlist> wishlistView() {
		String jpql = "from Wishlist";
		TypedQuery<Wishlist> qry = em.createQuery(jpql,Wishlist.class);
		List<Wishlist> wlist = qry.getResultList();
		return wlist;
	}
	
	@Override
	public boolean updateBook(Member book) {
		bk.save(book);
		return true;
	}

	@Override
	public void removeWishBook(int wish_list_id) {
		Wishlist book = em.find(Wishlist.class, wish_list_id);
	
		em.remove(book);
	}
	@Override
	public List<BookCopyForAdmin> ReturnedBookList() {
		return bookcopyadmindao.ReturnedBookList();		
	}
	@Override
	public void addReturnedBookForAdmin(int bid, int mid,LocalDate date) {
		bookcopyadmindao.addReturnedBookForAdmin(bid, mid , date);
	}
	@Override
	public boolean isbookqty0(int bid) {
		Book b = em.find(Book.class, bid);
		return b.getBook_qty()==0?true:false;
	}
}
