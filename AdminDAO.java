package com.raviinfotech.springstudentcrud.dao;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.raviinfotech.springstudentcrud.dto.Admin;
import com.raviinfotech.springstudentcrud.dto.Student;
import com.raviinfotech.springstudentcrud.exception.IdNotFound;
import com.raviinfotech.springstudentcrud.repository.AdminRepository;
import com.raviinfotech.springstudentcrud.util.ResponseStructure;

@Repository
public class AdminDAO {

	@Autowired
	private AdminRepository repo;
	
	public Admin saveAdmin(Admin admin) {
		return repo.save(admin);
	}
	
	public Admin loginadmin(Admin admin) {
		return repo.login(admin.getEmail());
	}
	public Admin findStudentById(int aid) {
		Optional<Admin> admin = repo.findById(aid);
		if(admin.isPresent()) {
			return admin.get();
		}else
			return null;
	}
	
	public Admin updateAdmin(Admin admin) {
		Admin admindb=findStudentById(admin.getAid());
		if(admindb != null) {
			return repo.save(admin);
		}else {
			return null;
		}
	}
	
	
	public void deleteAdminById(int aid) {
		Admin adminDb = findStudentById(aid);
		if (adminDb!=null) {
			repo.delete(adminDb);
		}else {
			throw new IdNotFound("id not found");
		}
	}
}