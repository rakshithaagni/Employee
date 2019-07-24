package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Employee;

// TODO: Auto-generated Javadoc
/**
 * The Interface EmployeeRepo.
 */
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

	/**
	 * Find by eid.
	 *
	 * @param eid the eid
	 * @return the employee
	 */
	Employee findByEid(Integer eid);

}
