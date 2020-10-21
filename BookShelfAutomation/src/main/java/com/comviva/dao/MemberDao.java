package com.comviva.dao;

import java.util.List;

import com.comviva.entity.Admin;

import com.comviva.entity.Member;
import com.comviva.entity.Role;

public interface MemberDao {

	public boolean adduser(Member member);
	public List<Member> viewall();
	public boolean findMember(int mid,String pass);
	public String getRedirection(int id);
	
}
