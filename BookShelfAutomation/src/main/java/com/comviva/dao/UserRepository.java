package com.comviva.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comviva.entity.Member;
import com.comviva.entity.Role;

@Repository
public interface UserRepository extends JpaRepository<Member,Integer> {

}
