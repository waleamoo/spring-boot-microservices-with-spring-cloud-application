package com.techqwerty.employeeservice.service;

import com.techqwerty.employeeservice.dto.APIResponseDto;
import com.techqwerty.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long employeeId);
}
