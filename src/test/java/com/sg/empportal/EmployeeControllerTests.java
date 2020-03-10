package com.sg.empportal;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.sg.empportal.model.Employee;
import com.sg.empportal.service.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTests {
	
	 	@Autowired
	    private MockMvc mvc;
	 
	    @MockBean
	    private EmployeeService service;

	    
	    @Test
	    public void whenGetEmployees_thenCheckStatusIsOK()
	      throws Exception {
	         
	        Employee vel = new Employee("Vel","Vel","Male","10-10-1981","IT");
	     
	        List<Employee> allEmployees = Arrays.asList(vel);
	     
	        when(service.viewEmployees()).thenReturn(allEmployees);
	     
	        mvc.perform(get("/employees")
	          .contentType(MediaType.APPLICATION_JSON))
	          .andExpect(status().isOk());
	          //.andExpect(jsonPath("$", hasSize(1)))
	          //.andExpect(jsonPath("$[0].name", is(vel.getFname())));
	    }
}
