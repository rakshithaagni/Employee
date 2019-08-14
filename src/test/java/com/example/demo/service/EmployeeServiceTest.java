package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.EmployeeDaoImpl;
import com.example.demo.model.Employee;
import com.example.demo.serviceimpl.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=EmployeeServiceImpl.class)
public class EmployeeServiceTest {
	
	@Autowired
	private EmployeeServiceImpl employeeservice;
	
	@MockBean
	private EmployeeDaoImpl employeedao;
	
	
	@Test
	public void testAddEmployee(){

		Employee emp = new Employee();
		emp.setEid(198);
		emp.setEname("task");
		
	    Mockito.when(employeedao.addEmployee(emp)).thenReturn(emp);
	    
	    assertThat(employeeservice.addEmployee(emp)).isEqualTo(emp);
	
	}
	
	@Test
	public void testDeleteEmployee(){

		Employee emp = new Employee();
		emp.setEid(523979);
		emp.setEname("raksitha");
		
	    Mockito.when(employeedao.deleteEmployee(523979)).thenReturn(null);
	    
//	    assertThat(employeeservice.deleteEmployee(523979)).isEqualTo(emp);
	
	}
	

	@Test
	public void getEmployee(){

		Employee emp = new Employee();
		emp.setEid(523979);
		emp.setEname("raksitha");
		
	    Mockito.when(employeedao.getEmployee(523979)).thenReturn(emp);
	    
	    assertThat(employeeservice.getEmployee(523979)).isEqualTo(emp);
	
	}
	
	@Test
	public void getEmployees(){

		Employee emp = new Employee();
		emp.setEid(523979);
		emp.setEname("raksitha");
		
		Employee emp2 = new Employee();
		emp2.setEid(523979);
		emp2.setEname("raksitha");
		
		List<Employee> employeelist = new ArrayList<>();
		
	    Mockito.when(employeedao.getEmployees()).thenReturn(employeelist);
	    
	    assertThat(employeeservice.getEmployees()).isEqualTo(employeelist);
	
	}
	
	

}
