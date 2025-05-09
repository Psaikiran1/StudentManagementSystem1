package com.raviinfotech.springstudentcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.raviinfotech.springstudentcrud.dto.Admin;
import com.raviinfotech.springstudentcrud.dto.Student;
import com.raviinfotech.springstudentcrud.service.AdminService;
import com.raviinfotech.springstudentcrud.util.ResponseStructure;

@RestController
@CrossOrigin("*")
public class AdminController {

	@Autowired
	private AdminService service;
	
	@PostMapping("saveadmin")
	public  ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin) {
		return service.saveAdmin(admin);
	}                               
	@PostMapping("loginadmin")
	public ResponseEntity<ResponseStructure<Admin>> loginadmin(@RequestBody Admin admin) {
		return service.loginadmin(admin);
	}
	
	@PutMapping("/updateAdmin")
	public ResponseEntity<ResponseStructure<Admin>>updateStudent(@RequestBody Admin admin){
		 return service.updateAdmin(admin);
	}
	
	@DeleteMapping("deleteAdminById/{aid}")
	public ResponseEntity<ResponseStructure<Admin>> deleteStudentById(@PathVariable int aid) {
		return service.deleteAdminById(aid);
	}
}