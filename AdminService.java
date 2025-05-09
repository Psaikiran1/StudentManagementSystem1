package com.raviinfotech.springstudentcrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.raviinfotech.springstudentcrud.dao.AdminDAO;
import com.raviinfotech.springstudentcrud.dto.Admin;
import com.raviinfotech.springstudentcrud.dto.Student;
import com.raviinfotech.springstudentcrud.exception.IdNotFound;
import com.raviinfotech.springstudentcrud.util.ResponseStructure;

@Service
public class AdminService {

	@Autowired
	private AdminDAO dao;
	
	ResponseStructure<Admin> structre = new ResponseStructure<Admin>();
	
	
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		structre.setData(dao.saveAdmin(admin));
		structre.setStatusCode(HttpStatus.OK.value());
		structre.setMsg("admin saved");
		return new ResponseEntity<ResponseStructure<Admin>>(structre,HttpStatus.OK);
	}
	
	
	
	
	public ResponseEntity<ResponseStructure<Admin>> loginadmin(Admin admin) {
		Admin admindb=dao.loginadmin(admin);
		if (admindb==null) {
			structre.setData(null);
			structre.setMsg("invalid email");
			structre.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structre,HttpStatus.NOT_FOUND);
		}
		if (admindb.getPassword().equals(admin.getPassword())) {
			structre.setData(admindb);
			structre.setMsg("login successfull");
			structre.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structre,HttpStatus.OK);
		}else {
			structre.setMsg("password incorrect");
			structre.setData(null);
			structre.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structre,HttpStatus.NOT_ACCEPTABLE);
			
		}
	}
	
	
	
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin) {
		Admin adminDb = dao.findStudentById(admin.getAid());
		System.out.println("update");
		if (adminDb != null) {
			structre.setData(dao.updateAdmin(admin));
			structre.setMsg("updated Sucessfully");
			structre.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structre,HttpStatus.ACCEPTED);
			
		}else {
			throw new IdNotFound("Id Not found");
		}
	}
	
	
	
	
	public ResponseEntity<ResponseStructure<Admin>> deleteAdminById(int aid) {
		Admin adminDb = dao.findStudentById(aid);
		
		if (adminDb!=null) {
			dao.deleteAdminById(aid);
			structre.setMsg("deleted successfull");
			structre.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Admin>>(structre,HttpStatus.OK);
		}else {
			throw new IdNotFound("id nt found");
		}
	}
		
}