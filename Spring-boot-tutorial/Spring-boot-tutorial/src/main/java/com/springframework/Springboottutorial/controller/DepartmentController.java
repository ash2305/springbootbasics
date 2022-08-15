package com.springframework.Springboottutorial.controller;

import com.springframework.Springboottutorial.entity.Department;
import com.springframework.Springboottutorial.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping(value = "/departments")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping(value = "/departments")
    public List<Department> retrieveAllDepartments(){
        return departmentService.retrieveAllDepartments();
    }

    @GetMapping(value = "/departments/{id}")
    public Department retrieveDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.retrieveDepartmentById(departmentId);
    }

    @DeleteMapping(value = "/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.deleteDepartmentById(departmentId);
    }

    @PutMapping(value = "/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartmentById(departmentId,department);
    }

}
