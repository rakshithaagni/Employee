package com.example.demo.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.controller.EmployeeController;
import com.example.demo.model.Employee;

@RunWith(SpringRunner.class)

@DataJpaTest




public class EmployeeDaoTest {
	
	@MockBean
	private EmployeeDaoImpl employeedao;
	
	@MockBean
	private TestEntityManager entityManager;
	
	@Test
	public void testAddEmployee(){

		Employee emp = new Employee();
		emp.setEid(198);
		emp.setEname("task");
		
	    Mockito.when(entityManager.persist(emp)).thenReturn(emp);
	    
	    assertThat(employeedao.addEmployee(emp)).isEqualTo(emp);
	
	}
	@Test
	public void testDeleteEmployee(){

		Employee emp1 = new Employee();
		emp1.setEid(7363);
		emp1.setEname("xjhjhx");
		
		
		Employee emp2 = new Employee();
		emp2.setEid(7363);
		emp2.setEname("xjhjhx");
		
		//Save both tickets in DB
		 entityManager.persist(emp1);
		entityManager.persist(emp2);
		
		//delete one ticket DB
		entityManager.remove(emp1);
		
		Iterable<Employee> allEmpFromDb = employeedao.getEmployees();
		List<Employee> employeelist = new ArrayList<>();
		
		for (Employee emp : allEmpFromDb) {
			employeelist.add(emp);
		}
		assertThat(employeelist.size()).isEqualTo(1);
	}
	
	@Test
	public void getEmployee(){
		

		Employee emp = new Employee();
		emp.setEid(123);
		emp.setEname("rks");
		
		
		//Save ticket in DB
		Employee EmpSavedInDb = entityManager.persist(emp);
		
		//Get Ticket from DB
		Employee EmpFromInDb = employeedao.getEmployee(EmpSavedInDb.getEid());
		assertThat(EmpSavedInDb).isEqualTo(EmpFromInDb);
	}
	
	@Test
	public void getEmployees(){
		
		Employee emp1 = new Employee();
		emp1.setEid(4646);
		emp1.setEname("Kol");
		
		Employee emp2 = new Employee();
		emp2.setEid(46746);
		emp2.setEname("Koudl");
		
		
		
		//Save both tickets in DB
		entityManager.persist(emp1);
		entityManager.persist(emp2);
		
		List<Employee> allEmpFromDb = employeedao.getEmployees();
		List<Employee> employeelist = new ArrayList<>();
		
		for (Employee emp: allEmpFromDb) {
			employeelist.add(emp);
		}
		assertThat(employeelist.size()).isEqualTo(2);

		
	
	}

	

}
