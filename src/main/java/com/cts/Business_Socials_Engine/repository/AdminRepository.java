package com.cts.Business_Socials_Engine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.Business_Socials_Engine.entity.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	public List<Admin> findByCategory(String category);

}
