package com.comviva.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.comviva.entity.Book;
import com.comviva.entity.Role;

@Repository("roledao")
@Transactional
public class RoleRepoImpl implements RoleDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Role find(String id) {
		String jpql = "from Role where role_desc = :role ";
		
		TypedQuery<Role> qry = em.createQuery(jpql,Role.class);
		qry.setParameter("role", id);
		
		List<Role> ans = new ArrayList<>();
		ans = qry.getResultList();
		return ans.size()>0?ans.get(0):new Role();
	}

}
