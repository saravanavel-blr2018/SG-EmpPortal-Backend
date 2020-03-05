package com.sg.empportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sg.empportal.model.Employee;
 
 
@Repository
public interface EmployeeRepository 
        extends JpaRepository<Employee, Long>,CrudRepository<Employee, Long> {
 
}