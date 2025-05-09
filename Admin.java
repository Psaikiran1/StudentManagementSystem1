package com.raviinfotech.springstudentcrud.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;



    @Entity
	  @Data
	  public class Admin {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int aid;
		private String fname;
		private String lname;
		@Column(unique = true)
		private String email;
		private String password;
		private String address;
		private long mobileNumber;
		
		
//		@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
//		@JoinTable(joinColumns = @JoinColumn(name = "aid"),inverseJoinColumns = @JoinColumn(name = "cid"))
//		@JsonIgnore
//		private List<Course> course;
		
	}


