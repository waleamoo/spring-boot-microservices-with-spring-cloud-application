package com.techqwerty.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techqwerty.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentCode(String departmentCode);
}
