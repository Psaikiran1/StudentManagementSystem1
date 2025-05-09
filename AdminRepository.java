package com.raviinfotech.springstudentcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.raviinfotech.springstudentcrud.dto.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

	@Query("select s from Admin s  where s.email=?1 ")
	 public Admin login(String email);
}