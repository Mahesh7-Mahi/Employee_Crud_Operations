package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.Employee;

public interface IEmployeeService {
	Integer saveEmployee(Employee emp);
	List<Employee> getAllEmployees();
	void deleteEmployee(Integer id);
	Employee updateEmployee(Integer id);
	void updateEmployee(Employee emp);
	Page<Employee> getAllEmployees(Pageable pageable);
}
