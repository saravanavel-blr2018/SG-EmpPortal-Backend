package com.sg.empportal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.empportal.model.Employee;
import com.sg.empportal.repository.EmployeeRepository;

@Service
public class EmployeeService {

	 @Autowired
	 EmployeeRepository empRepository;
	
	private List<Employee> employees = new ArrayList<>();
	
	public List<Employee> viewEmployees(){
		List<Employee> employees = empRepository.findAll();
		return employees;
	}
	
	public Employee viewEmployee(Long empId){
		Optional<Employee> employee = empRepository.findById(empId);
		return employee.orElse(new Employee("Unknown Employee","Unknow Empoyee","","",""));
	}
	
	public Employee registerEmployee(Employee emp){
		empRepository.save(emp);
		employees.add(emp);
		return emp;
	}
}
