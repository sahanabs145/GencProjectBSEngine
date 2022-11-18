package com.cts.Business_Socials_Engine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_portal")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class User {
	
//	public User() {
//		//super();
//	}

//	public User(String userKey, String emailId, int businessId, double rating) {
//		super();
//		this.userKey = userKey;
//		this.emailId = emailId;
//		this.businessId = businessId;
//		this.rating = rating;
//	}

	@Id
	@Column(length = 50)
	private String userKey;
	
	@Column(length = 50)
	private String emailId;

	@Column(name = "businessid")
	private int businessId;
	
	@Column(name = "rating")
	private double rating;

	
	public int getBusinessId() {
		return businessId;
	}

	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserKey() {
		return userKey;
	}

	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	
	
}
