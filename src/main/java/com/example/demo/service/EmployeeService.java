package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Employee;

// TODO: Auto-generated Javadoc
/**
 * The Interface EmployeeService.
 */
public interface EmployeeService {
	
	/**
	 * Delete employee.
	 *
	 * @param eid the eid
	 * @return the string
	 */
	public String deleteEmployee(int eid);
	
	/**
	 * Gets the employees.
	 *
	 * @return the employees
	 */
	public List<Employee> getEmployees();
	
	/**
	 * Adds the employee.
	 *
	 * @param emp the emp
	 * @return the employee
	 */
	public Employee addEmployee( Employee emp);
	
	/**
	 * Gets the employee.
	 *
	 * @param eid the eid
	 * @return the employee
	 */
	public Employee getEmployee( int eid);
}
