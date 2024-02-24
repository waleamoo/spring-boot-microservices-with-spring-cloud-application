package com.techqwerty.employeeservice.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.techqwerty.employeeservice.dto.APIResponseDto;
import com.techqwerty.employeeservice.dto.DepartmentDto;
import com.techqwerty.employeeservice.dto.EmployeeDto;
import com.techqwerty.employeeservice.entity.Employee;
import com.techqwerty.employeeservice.mapper.EmployeeMapper;
import com.techqwerty.employeeservice.repository.EmployeeRepository;
import com.techqwerty.employeeservice.service.APIClient;
import com.techqwerty.employeeservice.service.EmployeeService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

// private RestTemplate restTemplate;
    private WebClient webClient;
//     private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee saveDEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(saveDEmployee);

        return savedEmployeeDto;
    }

    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();

        // ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://DEPARTMENT-SERVICE/api/departments/" + employee.getDepartmentCode(),DepartmentDto.class);

        // DepartmentDto departmentDto = responseEntity.getBody();

       DepartmentDto departmentDto = webClient.get()
               .uri("http://localhost:8081/api/departments/" + employee.getDepartmentCode())
               .retrieve()
               .bodyToMono(DepartmentDto.class)
               .block();

      //  DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }

    public APIResponseDto getDefaultDepartment(Long employeeId, Exception exception) {
        Employee employee = employeeRepository.findById(employeeId).get();

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName("R & D Department");
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentDescription("Reasearch and development department");
        
        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }
    
}
