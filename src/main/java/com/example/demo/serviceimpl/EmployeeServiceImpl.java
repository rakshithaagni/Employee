package com.example.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
// TODO: Auto-generated Javadoc

/**
 * The Class EmployeeServiceImpl.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	/** The employeedao. */
	@Autowired
	private EmployeeDao employeedao;
	

	/* (non-Javadoc)
	 * @see com.example.demo.service.EmployeeService#addEmployee(com.example.demo.model.Employee)
	 */
	@Override
	public Employee addEmployee( Employee emp) {
		return employeedao.addEmployee(emp);
	}
	
	/* (non-Javadoc)
	 * @see com.example.demo.service.EmployeeService#deleteEmployee(int)
	 */

	public String deleteEmployee( int eid) {
		return  this.employeedao.deleteEmployee(eid);
	}
	
	/* (non-Javadoc)
	 * @see com.example.demo.service.EmployeeService#getEmployees()
	 */
	public List<Employee> getEmployees() {
		return this.employeedao.getEmployees();
	}
	
	/* (non-Javadoc)
	 * @see com.example.demo.service.EmployeeService#getEmployee(int)
	 */
	public Employee getEmployee(int eid) {
		return   this.employeedao.getEmployee(eid);

	}
}
