package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.model.Employee;
import com.example.demo.serviceimpl.EmployeeServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value=EmployeeController.class,secure=false)

public class EmployeeControllerTest {

@Autowired
private MockMvc mockMvc;

@MockBean
private EmployeeServiceImpl employeeservice;


@Test
public void testAddEmployee() throws Exception{
	Employee mockEmp =new Employee();
	mockEmp.setEid(123);
	mockEmp.setEname("jai");
	String InputJson= this.mapToJson(mockEmp);
	String URI = "/addEmployee";
	
	Mockito.when(employeeservice.addEmployee(Mockito.any(Employee.class))).thenReturn(mockEmp);
	RequestBuilder requestBuilder = MockMvcRequestBuilders
			.post(URI)
			.accept(MediaType.APPLICATION_JSON).content(InputJson)
			.contentType(MediaType.APPLICATION_JSON);
			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			MockHttpServletResponse response = result.getResponse();
			
			String outputInJson = response.getContentAsString();
			
			assertThat(outputInJson).isEqualTo(InputJson);
			assertEquals(HttpStatus.OK.value(), response.getStatus());
			
	
}
@Test
public void testGetEmployee() throws Exception {
	Employee emp = new Employee();
	emp.setEid(523979);
	emp.setEname("Martin Bingel");
	
	
	Mockito.when(employeeservice.getEmployee(Mockito.anyInt())).thenReturn(emp);
	
	String URI = "/employee/523979";
	RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
			URI).accept(
			MediaType.APPLICATION_JSON);

	MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	String expectedJson = this.mapToJson(emp);
	String outputInJson = result.getResponse().getContentAsString();
	assertThat(outputInJson).isEqualTo(expectedJson);
}

@Test
public void testDeleteEmployee() throws Exception {
	Employee mockEmp = new Employee();
	mockEmp.setEid(523979);
	mockEmp.setEname("rakshitha");
	
	
	Mockito.when(employeeservice.deleteEmployee(Mockito.anyInt())).thenReturn("success");
	
	String URI = "/deleteEmployee/523979";
	RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
			URI).accept(
			MediaType.APPLICATION_JSON);

	MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	String expectedJson = this.mapToJson(mockEmp);
	String outputInJson = result.getResponse().getContentAsString();
	assertThat(outputInJson).isEqualTo(expectedJson);
}

@Test
public void testGetEmployees() throws Exception {
	Employee mockEmp1 = new Employee();
	mockEmp1.setEid(523979);
	mockEmp1.setEname("rakshitha");
	
	Employee mockEmp2 = new Employee();
	mockEmp2.setEid(5239769);
	mockEmp2.setEname("edshereen");
	
	List<Employee> employeelist = new ArrayList<>();
	employeelist.add(mockEmp1);
	employeelist.add(mockEmp2);
	
	
	Mockito.when(employeeservice.getEmployees()).thenReturn(employeelist);
	
	String URI = "/employees";
	RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
			URI).accept(
			MediaType.APPLICATION_JSON);

	MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	String expectedJson = this.mapToJson(employeelist);
	String outputInJson = result.getResponse().getContentAsString();
	assertThat(outputInJson).isEqualTo(expectedJson);
}


private String mapToJson(Object object) throws JsonProcessingException {
	ObjectMapper objectMapper = new ObjectMapper();
	return objectMapper.writeValueAsString(object);
}
	
}
