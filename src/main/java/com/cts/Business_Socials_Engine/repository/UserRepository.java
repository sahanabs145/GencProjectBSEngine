package com.cts.Business_Socials_Engine.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.Business_Socials_Engine.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
	@Query(value = "select avg(u.rating) from User u where businessId = :id group by businessId")
	public BigDecimal getAvgRatingGroupBy(@Param("id") int id);

}
