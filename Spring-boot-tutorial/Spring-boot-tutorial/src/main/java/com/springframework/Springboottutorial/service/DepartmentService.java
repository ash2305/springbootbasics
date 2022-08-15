package com.springframework.Springboottutorial.service;

import com.springframework.Springboottutorial.entity.Department;

import java.util.List;

public interface DepartmentService {
    
    public Department saveDepartment(Department department);

    public List<Department> retrieveAllDepartments();

    public Department retrieveDepartmentById(Long departmentId);

    public String deleteDepartmentById(Long departmentId);

    public Department updateDepartmentById(Long departmentId, Department department);
}
