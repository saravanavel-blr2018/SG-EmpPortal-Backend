package com.sg.empportal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sg.empportal.model.Employee;
import com.sg.empportal.repository.EmployeeRepository;
import com.sg.empportal.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTests {

	@Autowired
	private EmployeeService empService;
	
	@MockBean	
	private EmployeeRepository repository;
	
 

	@Test
	public void contextLoads() {
	}

	/* 
	 * Employee Service Test
	 * Mock Repository to mimic repository and DB operation and inject service to use mocked repostiory to perform DB operations 
	 */
	@Test
	public void testViewEmployees() {
		when(repository.findAll()).thenReturn(Stream.of(new Employee("vel","vel","Male","01-01-1981","IT"),new Employee("vel1","vel1","Male","01-01-1981","ITA")).collect(Collectors.toList()));
		assertEquals(2, empService.viewEmployees().size());
	}
	
	
	@Test
	public void testRegisterEmployee(){
		Employee emp = new Employee("Vel","Vel","Male","01-01-1981","IT DEPT");
		when(repository.save(emp)).thenReturn(emp);
		assertEquals(emp, empService.registerEmployee(emp));
	}

}
