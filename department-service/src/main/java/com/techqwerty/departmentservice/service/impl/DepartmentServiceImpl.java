package com.techqwerty.departmentservice.service.impl;

import org.springframework.stereotype.Service;
import com.techqwerty.departmentservice.dto.DepartmentDto;
import com.techqwerty.departmentservice.entity.Department;
import com.techqwerty.departmentservice.mapper.DepartmentMapper;
import com.techqwerty.departmentservice.repository.DepartmentRepository;
import com.techqwerty.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        // convert department dto to department jpa entity
        Department department = DepartmentMapper.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);
        return departmentDto;
    }

    
    
}
