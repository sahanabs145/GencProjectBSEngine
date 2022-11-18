package com.cts.Business_Socials_Engine.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "admin_portal")
@Getter @Setter //@AllArgsConstructor @NoArgsConstructor
public class Admin {
	
	public Admin(int id, String name, String address, long phno, String category, BigDecimal avgRating) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phno = phno;
		this.category = category;
		this.avgRating = avgRating;
	}

	public Admin() {
		//super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "contact")
	private long phno;
	
	@Column(name ="category")
	private String category;
	
	@Column(name = "avgRating", precision = 2, scale = 1)
	private BigDecimal avgRating;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public BigDecimal getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(BigDecimal avgRating) {
		this.avgRating = avgRating;
	}

	

}
