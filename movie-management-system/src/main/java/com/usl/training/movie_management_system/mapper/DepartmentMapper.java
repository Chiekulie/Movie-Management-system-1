package com.usl.training.movie_management_system.mapper;

import com.usl.training.movie_management_system.dto.DepartmentDto;
import com.usl.training.movie_management_system.entity.Department;
public class DepartmentMapper {

    public static DepartmentDto mapToDto(Department department) {
        return new DepartmentDto(department.getDepartmentId(), department.getDepartmentName());
    }

    public static Department mapToEntity(DepartmentDto departmentDto) {
        return new Department(departmentDto.getDepartmentId(), departmentDto.getDepartmentName());
    }
}



