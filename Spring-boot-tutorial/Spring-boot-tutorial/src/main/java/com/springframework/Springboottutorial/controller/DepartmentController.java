package com.springframework.Springboottutorial.controller;

import com.springframework.Springboottutorial.entity.Department;
import com.springframework.Springboottutorial.error.DepartmentNotFoundException;
import com.springframework.Springboottutorial.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping(value = "/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Saving the department is called");
        return departmentService.saveDepartment(department);
    }

    @GetMapping(value = "/departments")
    public List<Department> retrieveAllDepartments(){
        LOGGER.info("fetching the department method is called");
        return departmentService.retrieveAllDepartments();
    }

    @GetMapping(value = "/departments/{id}")
    public Department retrieveDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
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

    @GetMapping(value = "/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
