package com.code.crud.employeecrud.dao;

import com.code.crud.employeecrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	//Method to sort by Last Name
    public List<Employee> findAllByOrderByLastNameAsc();

}
