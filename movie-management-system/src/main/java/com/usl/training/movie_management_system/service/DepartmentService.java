package com.usl.training.movie_management_system.service;

import com.usl.training.movie_management_system.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto getDepartmentById(Integer department);
    List<DepartmentDto> getAllDepartments();

    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto updateDepartment(Integer departmentId, DepartmentDto departmentDto);

    void deleteDepartment(Integer departmentId);

}
