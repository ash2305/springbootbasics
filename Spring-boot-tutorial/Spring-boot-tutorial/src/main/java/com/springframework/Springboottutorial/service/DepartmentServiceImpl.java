package com.springframework.Springboottutorial.service;

import com.springframework.Springboottutorial.entity.Department;
import com.springframework.Springboottutorial.error.DepartmentNotFoundException;
import com.springframework.Springboottutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> retrieveAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department retrieveDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);

        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department not available");
        }

        return department.get();
    }

    @Override
    public String deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
        return "Deleted Successfully";
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) {
        Department depData = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName()))
        {
            depData.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress()))
        {
            depData.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode()))
        {
            depData.setDepartmentCode(department.getDepartmentCode());
        }

        return departmentRepository.save(depData);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
