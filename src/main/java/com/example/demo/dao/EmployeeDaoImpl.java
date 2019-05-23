package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Employee;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeDaoImpl.
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	/** The repository. */
	@Autowired
	EmployeeRepo repository;
	
	/* (non-Javadoc)
	 * @see com.example.demo.dao.EmployeeDao#addEmployee(com.example.demo.model.Employee)
	 */
	@Override
	public  Employee addEmployee(Employee emp) {
		return repository.save(emp);
		 
		
	}
	
	/* (non-Javadoc)
	 * @see com.example.demo.dao.EmployeeDao#deleteEmployee(int)
	 */
	@Override
	public String deleteEmployee(int eid) {
		repository.deleteById(eid);
		return "success";
	}
	
	/* (non-Javadoc)
	 * @see com.example.demo.dao.EmployeeDao#getEmployees()
	 */
	@Override
	public List<Employee> getEmployees() {
		return (List<Employee>) repository.findAll();
	}
	
	/* (non-Javadoc)
	 * @see com.example.demo.dao.EmployeeDao#getEmployee(int)
	 */
	@Override
	public Employee getEmployee(int eid) {
		return repository.findByEid(eid);

}
	

}
