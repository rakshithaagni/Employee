package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeRepo;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;





// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeController.
 */
@RestController
public class EmployeeController {
	
	/** The employeeservice. */
	@Autowired
	EmployeeService employeeservice;
	
	
	
//	@RequestMapping("/get")
//	public String gett() {
//		return "get called";
//	}

	/**
 * Adds the employee.
 *
 * @param emp the emp
 * @return the employee
 */

@PostMapping("/addemploy")

	public Employee addEmployee(Employee emp) {
		
		
	return employeeservice.addEmployee(emp);
	
		
		
	}

	/**
	 * Delete employee.
	 *
	 * @param eid the eid
	 * @return the string
	 */

	@GetMapping("/deleteemployee/{eid}")
	@ResponseBody
	public String deleteEmployee(@PathVariable int eid) {
		
		
		return employeeservice.deleteEmployee(eid);
	    
		
		

	}

	
	/**
	 * Gets the employees.
	 *
	 * @return the employees
	 */
	@GetMapping("/employees")
	@ResponseBody
	public List<Employee> getEmployees() {
	return employeeservice.getEmployees();

	}

	/**
	 * Gets the employee.
	 *
	 * @param eid the eid
	 * @return the employee
	 */
	@GetMapping("/employee/{eid}")
	@ResponseBody
	public Employee getEmployee(@PathVariable int eid) {
		return   employeeservice.getEmployee(eid);

	}
//	
}
