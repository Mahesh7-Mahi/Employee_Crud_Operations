package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	private Integer eid;
	
	private String ename;
	private String email;
	
	private Double esal;
	private String edept;
	
	private Double hra;
	private Double da;
}
