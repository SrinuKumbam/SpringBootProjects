package com.boot.training.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.boot.training.model.RestUser;

public interface UserRepository extends JpaRepository<RestUser, Long>{

	//@Query("SELECT u FROM USER_TAB u WHERE u.last_name = lastName")
	//Collection<RestUser> selectUsersByLastName(@Param(value = "lastName") String lastName);
}
