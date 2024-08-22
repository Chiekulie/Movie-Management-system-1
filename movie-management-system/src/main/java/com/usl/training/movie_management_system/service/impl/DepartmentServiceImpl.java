package com.usl.training.movie_management_system.service.impl;

import com.usl.training.movie_management_system.dto.DepartmentDto;
import com.usl.training.movie_management_system.entity.Department;
import com.usl.training.movie_management_system.exceptions.ResourceNotFoundException;
import com.usl.training.movie_management_system.mapper.DepartmentMapper;
import com.usl.training.movie_management_system.repository.DepartmentRepository;
import com.usl.training.movie_management_system.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

private final DepartmentRepository departmentRepository;




    @Override
    public DepartmentDto getDepartmentById(Integer departmentId) {

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + departmentId));

        return DepartmentMapper.mapToDto(department);
    }




    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream()
                .map(DepartmentMapper::mapToDto)
                .collect(Collectors.toList());
    }





    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToEntity(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDto(savedDepartment);

    }







    @Override
    public DepartmentDto updateDepartment(Integer departmentId, DepartmentDto departmentDto) {
        Department existingDepartment = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + departmentId));

        existingDepartment.setDepartmentName(departmentDto.getDepartmentName());

        Department updatedDepartment = departmentRepository.save(existingDepartment);
        return DepartmentMapper.mapToDto(updatedDepartment);
    }

    public void deleteDepartment(Integer departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + departmentId));
        departmentRepository.delete(department);
    }
}

