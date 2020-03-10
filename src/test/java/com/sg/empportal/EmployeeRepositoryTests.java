package com.sg.empportal;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sg.empportal.model.Employee;
import com.sg.empportal.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest
public class EmployeeRepositoryTests {
	
    @Autowired
    private static TestEntityManager entityManager;
    
    @Autowired	
	private EmployeeRepository employeeRepository;
	
    private static Employee vel;
    
	
	 @BeforeEach
	 public static void registerDummyEmployee() { 
		 vel = new Employee("vel123","vel","Male","01-01-1981","IT");
		 entityManager.persist(vel);
		 System.out.print("Dummy Employee Id:"+vel.getId()); entityManager.flush(); 
	 }
	
	
	@Test
	public void whenViewEmployees_thenReturnEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		assertThat(employees.size()).isGreaterThanOrEqualTo(1);
	}
	
}
