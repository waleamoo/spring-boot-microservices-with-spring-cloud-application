package com.techqwerty.employeeservice.mapper;

import com.techqwerty.employeeservice.dto.EmployeeDto;
import com.techqwerty.employeeservice.entity.Employee;

public class EmployeeMapper {
    
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        EmployeeDto employeeDto = new EmployeeDto(
            employee.getId(), 
            employee.getFirstName(),
            employee.getLastName(),
            employee.getLastName(),
            employee.getDepartmentCode()
        );
        return employeeDto;
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee(
            employeeDto.getId(), 
            employeeDto.getFirstName(),
            employeeDto.getLastName(),
            employeeDto.getLastName(),
            employeeDto.getDepartmentCode()
        );
        return employee;
    }
}
