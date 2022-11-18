package com.cts.Business_Socials_Engine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.Business_Socials_Engine.entity.Admin;
import com.cts.Business_Socials_Engine.entity.User;
import com.cts.Business_Socials_Engine.service.AdminService;
import com.cts.Business_Socials_Engine.service.UserService;

@Controller
@RequestMapping("/bsengine/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AdminService adminService;

	@GetMapping("/aboutUs")
	public String getAboutUs() {
		return "about-us";
	}

	@GetMapping("/contactUs")
	public String getContactUs() {
		return "contact-us";
	}

	@GetMapping("/searchPage")
	public String getSearchPage(ModelMap model) {
		return "customer-search-page";
	}

	@PostMapping("/searchBusiness")
	public String searchBusiness(ModelMap model, @RequestParam("category") String category) {
		List<Admin> list = userService.searchBusiness(category);

		model.put("results", list);
		model.put("category", category);
		return "search-results";
	}

	@GetMapping("/ratingForm/{id}")
	public String getRatingForm(ModelMap model, @PathVariable("id") int id) {
		model.put("businessId", id);
		model.put("user", new User());
		return "rating-form";
	}

	@PostMapping("/submitRating")
	public String submitRating(@ModelAttribute(value = "user") User user, ModelMap model) {
		userService.saveRating(user);
		
		int id = user.getBusinessId(); 
		String category = adminService.viewEntryById(id).getCategory();
		List<Admin> list = userService.searchBusiness(category);

		model.put("results", list);
		model.put("category", category);
		return "search-results";
	}

}
