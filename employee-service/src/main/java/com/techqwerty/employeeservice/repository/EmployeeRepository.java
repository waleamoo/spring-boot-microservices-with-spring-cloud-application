package com.techqwerty.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techqwerty.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}
