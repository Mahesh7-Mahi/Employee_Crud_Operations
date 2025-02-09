package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;
import com.example.demo.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	private EmployeeRepository emprepo;
	
	@Override
	public Integer saveEmployee(Employee emp) {
		Double esal=emp.getEsal();
		Double hra=esal*20/100.0;
		Double da=esal*10/100.0;
		emp.setHra(hra);
		emp.setDa(da);
		emprepo.save(emp);
		Integer id=emp.getEid();
		return id;
	}
	
	
	public List<Employee> getAllEmployees() {
		return emprepo.findAll();
	}
	
	public void deleteEmployee(Integer id) {
		//Employee emp=emprepo.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee "+id+" Not Exist"));
		Employee emp=updateEmployee(id);
		emprepo.delete(emp);
		/*if(emprepo.existsById(id)) {
			emprepo.deleteById(id);
		}
		else {
			throw new EmployeeNotFoundException("Employee "+id+" Not Exist");
		}*/
		
	}
	
	@Override
	public Employee updateEmployee(Integer id) {
		Employee emp=emprepo.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee "+id+" Not Exist"));
		return emp;
		/*Optional<Employee> opt= emprepo.findById(id);
		if(opt.isPresent()) {
			Employee emp=opt.get();
			return emp;
		}
		else {
			throw new EmployeeNotFoundException("Employee "+id+" Not Exist");
		}*/
		
	}
	@Override
	public void updateEmployee(Employee emp) {
		if(emprepo.existsById(emp.getEid())) {
			Double esal=emp.getEsal();
			Double hra=esal*20/100.0;
			Double da=esal*10/100.0;
			emp.setHra(hra);
			emp.setDa(da);
			emprepo.save(emp);
		}
		else {
			System.out.println("Employee doesn't exit");
		}
	}
	
	public Page<Employee> getAllEmployees(Pageable pageable){
		Page<Employee> page=emprepo.findAll(pageable);
		return page;
	}


}
