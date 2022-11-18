package com.cts.Business_Socials_Engine.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.Business_Socials_Engine.repository.AdminRepository;
import com.cts.Business_Socials_Engine.entity.Admin;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Transactional
	public List<Admin> viewEntries(){
		return adminRepository.findAll();
	}
	
	@Transactional
	public Admin viewEntryById(int id){
		return adminRepository.findById(id).get();
	}
	
	@Transactional
	public void addEntry(Admin obj) {
		obj.setAvgRating(new BigDecimal(0.0));
		adminRepository.save(obj);
	}
	
	@Transactional
	public void deleteEntry(int id) {
		Admin obj = adminRepository.findById(id).get();
		adminRepository.delete(obj);
	}


}
