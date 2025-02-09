package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.service.IEmployeeService;

@Controller
public class EmployeeController {
	
	private Logger log=LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private IEmployeeService empservice;
	//1.show register page
	@GetMapping("/register")
	public String showRegister() {
		return "EmployeeRegisterPage";
	}
	
	//Save employee details
	@PostMapping("/save")
	public String savePage(
			@ModelAttribute Employee employee,
			Model model
			) {
		log.info("ENTERD INTO THE SAVE EMPLOYEE METHOD");
		try{
			Integer empid=empservice.saveEmployee(employee);
			log.info("EMPLOYEE SAVED SUCCESSFULLY");
			String msg="Employee '"+empid+"' saved";
			model.addAttribute("msg", msg);
		}catch(Exception e) {
			log.info("UNABLE TO PROCESS YOUR REQUEST AND WE UNABLE TO SAVE EMPLOYEE {}",e.getMessage());
			e.printStackTrace();
		}
		log.info("ABOUT TO RETURN RESPONSE FROM SAVE EMPLOYEE METHOD");
		return "EmployeeRegisterPage";
	}
	
	//Get all employee details
	/*
	@GetMapping("/all")
	public String showAllEmployees(Model model) {
		List<Employee> list=empservice.getAllEmployees();
		model.addAttribute("list",list);
		return "EmpData";
	}
	*/
	
	@GetMapping("/all")
	public String showAllEmployees(
			@PageableDefault(page=0,size=3)Pageable pageable,
			Model model) {
		log.info("ENTERD INTO THE SHOWALLEMPLOYEES METHOD");
		Page<Employee> page=empservice.getAllEmployees(pageable);
		List<Employee> list=page.getContent();
		
		model.addAttribute("list",list);
		model.addAttribute("page",page);
		return "EmpData";
	}
	
	
	//Delete employee by using employee id
	@GetMapping("/delete")
	public String deleteEmployeeById(
			@RequestParam Integer eid,
			Model model
			) {
		log.info("ENTERD INTO THE DELETE EMPLOYEE METHOD");
		try {
			empservice.deleteEmployee(eid);
			List<Employee> list=empservice.getAllEmployees();
			model.addAttribute("list",list);
			log.info("EMPLOYEE DELETED");
			String msg="Employee '"+eid+"' deleted from db";
			model.addAttribute("msg",msg);	
		}catch(EmployeeNotFoundException e) {
			log.info("EMPLOYEE NOT DELETED {}",e.getMessage());
			e.printStackTrace();
			throw e;
		}
		log.info("ABOUT TO RETURN RESPONSE FROM DELETE EMPLOYEE METHOD");
		return "EmpData";
		//return "redirect:/all";
	}
	
	//Updating the employee details
	@GetMapping("/update")
	public String updatingEmployeePage(
			@RequestParam Integer eid,
			Model model
			) {
		log.info("ENTERD INTO THE UPDATE EMPLOYEE METHOD");
		try {
			Employee emp=empservice.updateEmployee(eid);
			model.addAttribute("employee",emp);
			log.info("EMPLOYEE DETAILS UPDATED");
		}catch(EmployeeNotFoundException e) {
			log.info("EMPLOYEE NOT UPDATED",e.getMessage());
			e.printStackTrace();
			throw e;
		}
		log.info("ABOUT TO RETURN RESPONSE FROM UPDATE EMPLOYEE METHOD");
		return "EmployeeRegisterEdit";
	}
	
	@PostMapping("/update")
	public String updateEmployee(
			@ModelAttribute Employee employee,
			Model model
			) {
		empservice.updateEmployee(employee);
		return "redirect:all";
	}
}
