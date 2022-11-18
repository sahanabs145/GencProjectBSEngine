package com.cts.Business_Socials_Engine.service;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.Business_Socials_Engine.entity.User;
import com.cts.Business_Socials_Engine.repository.AdminRepository;
import com.cts.Business_Socials_Engine.repository.UserRepository;
import com.cts.Business_Socials_Engine.entity.Admin;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Transactional
	public void saveRating(User obj) {
		obj.setUserKey(obj.getEmailId()+obj.getBusinessId());
		userRepository.save(obj);
		BigDecimal val = userRepository.getAvgRatingGroupBy(obj.getBusinessId());
		Admin ob = adminRepository.getById(obj.getBusinessId());
		ob.setAvgRating(val);
		adminRepository.save(ob);
	}
	
	@Transactional
	public List<Admin> searchBusiness(String category) {
		return adminRepository.findByCategory(category);
	}

}
