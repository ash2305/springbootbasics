package com.springframework.Springboottutorial.service;

import com.springframework.Springboottutorial.entity.Department;
import com.springframework.Springboottutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    
    public Department saveDepartment(Department department);

    public List<Department> retrieveAllDepartments();

    public Department retrieveDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public String deleteDepartmentById(Long departmentId);

    public Department updateDepartmentById(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
