package com.raviinfotech.springstudentcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.raviinfotech.springstudentcrud.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	public Student findStudentById(int id);
	
	@Query("select s from Student s  where s.email=?1 AND s.password=?2")
	 public Student login(String email,String password);
}
