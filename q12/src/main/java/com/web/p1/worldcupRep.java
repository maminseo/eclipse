package com.web.p1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface worldcupRep extends JpaRepository<worldcup,Integer>{
	@Transactional
	@Modifying
	@Query("update worldcup set fcount=fcount+1 where name=?1") 
	void increaseFcount(String name); 
}
