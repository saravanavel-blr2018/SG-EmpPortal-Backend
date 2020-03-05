package com.sg.empportal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sg.empportal.model.Employee;
import com.sg.empportal.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Api(value = "/employeeporal", description = "SG Employee Management Portal", produces = "application/json")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@ApiOperation(value = "View All Employees", response = Employee.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Employees List", response = Employee.class, responseContainer = "List"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "No Employee found") })
	@GetMapping("/employees")
	List<Employee> viewEmployees() {
		return empService.viewEmployees();
	}

	@ApiOperation(value = "View Employee By ID", response = Employee.class)
	// @ApiParam(value="empId",required=true)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "empId", value = "Employee id", required = true, dataType = "Long", paramType = "path") })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Employee Details", response = Employee.class),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 404, message = "Employee not found") })
	@GetMapping("/employees/{empId}")
	Employee viewEmployee(@PathVariable Long empId) {
		return empService.viewEmployee(empId);
	}

	@ApiOperation(value = "Create New Employee", response = Employee.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "New Employee is added!!!", response = Employee.class),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	@PostMapping(path = "/employees", consumes = "application/json", produces = "application/json")
	Employee registerEmployee(@RequestBody Employee emp) {
		return empService.registerEmployee(emp);
	}

	@ApiOperation(value = "Update Employee Information", response = Employee.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Employee information is updated!!!", response = Employee.class),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	@PutMapping(path = "/employees", consumes = "application/json", produces = "application/json")
	Employee updateEmployee(@RequestBody Employee emp) {
		return empService.registerEmployee(emp);
	}

}
