package com.cts.Business_Socials_Engine.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cts.Business_Socials_Engine.entity.Admin;
import com.cts.Business_Socials_Engine.service.AdminService;

@Controller
@RequestMapping("/bsengine/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/portal")
	public String viewAllBusinesses(ModelMap model) {
		List<Admin> businessList = adminService.viewEntries();
		model.put("businessList", businessList);
		return "admin-portal";
	}

	@GetMapping("/entryPage")
	public String addEntryPage(ModelMap model) {
		model.put("business", new Admin());
		return "add-entry-page";
	}

	@PostMapping("/portal")
	public String addBusiness(@ModelAttribute(value = "business") Admin admin, ModelMap model) {
		String cat = admin.getCategory();
		admin.setCategory(cat.toLowerCase());
		adminService.addEntry(admin);
		List<Admin> businessList = adminService.viewEntries();
		model.put("businessList", businessList);
		return "admin-portal";
	}
	
	@GetMapping("/removeBusiness/{id}")
	public String removeBusiness(@PathVariable("id") int id, ModelMap model) {
		adminService.deleteEntry(id);
		List<Admin> businessList = adminService.viewEntries();
		model.put("businessList", businessList);
		
		return "admin-portal";
	}

	@ModelAttribute("categoryList")
	public List<String> buildState() {
		return Arrays.asList("Electronics", "Electrical", "Cosmetics", "Health Clinics", "Rentals Cars",
				"Real Estate Brokers");
	}

}
