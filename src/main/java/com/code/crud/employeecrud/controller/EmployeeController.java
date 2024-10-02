package com.code.crud.employeecrud.controller;


import com.code.crud.employeecrud.entity.Employee;
import com.code.crud.employeecrud.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService theEmployeeService){
		employeeService = theEmployeeService;
	}

	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		List<Employee> theEmployees = employeeService.findAll();
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForADD(Model theModel){

		Employee theEmployee = new Employee();

		theModel.addAttribute("employee",theEmployee);

		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){

		employeeService.save(theEmployee);

		return "redirect:/employees/list";

	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model theModel){

		//get the employee from the code
		Employee theEmployee = employeeService.findById(theId);

		//set employee in the model to prepopulate the form
		theModel.addAttribute("employee",theEmployee);

		//send over to our form
		return "employees/employee-form";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId){

		//delete the employee
		employeeService.deleteById(theId);
		//redirect to /employees/list
		return "redirect:/employees/list";
	}

}









