package com.comviva.dao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.comviva.entity.Admin;
import com.comviva.entity.Member;
import com.comviva.entity.Role;

@Transactional
@Repository("memberdao")
public class MemberDaoImpl implements MemberDao {
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private PasswordEncoder  encoder;
	
	@Autowired
	private RoleDao rdoa;
	
	@Value("${userRoleType}")
	private String userType;
	

	@Override
	public boolean adduser(Member member) {
		member.setPass(encoder.encode(member.getPass()));
		System.out.println(userType);
		Role userRole = rdoa.find(userType);
		member.setRoles(new HashSet<>(Arrays.asList(userRole)));
		em.persist(member);
		return true;
	}
	
	@Override
	public List<Member> viewall() {
		String jpql = "from Member";
		TypedQuery<Member> qry = em.createQuery(jpql ,Member.class);
		return qry.getResultList();
	}
	
	@Override
	public boolean findMember(int mid,String pass) {
		Member mem = em.find(Member.class, mid);
		if(mem != null) {
			if(encoder.matches(pass, mem.getPass())) {
				return true;
			}
		}
		return false;
		
	}
	@Override
	public String getRedirection(int uid) {
		Member mem = em.find(Member.class, uid);
		System.out.println(mem.getRoles().toString());
		if(mem.getRoles().toString().equals("[USER]"))
			return "Welcome";
		else
			return "redirect:/adminpage";
//		return "Welcome";
	}



}
