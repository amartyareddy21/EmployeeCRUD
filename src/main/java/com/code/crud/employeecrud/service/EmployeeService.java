package com.code.crud.employeecrud.service;

import com.code.crud.employeecrud.entity.Employee;

import java.util.List;


public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	void save(Employee theEmployee);
	
	void deleteById(int theId);
	
}
