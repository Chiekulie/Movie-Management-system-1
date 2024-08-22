package com.usl.training.movie_management_system.service.impl;

import com.usl.training.movie_management_system.dto.LanguageRoleDto;
import com.usl.training.movie_management_system.entity.LanguageRole;
import com.usl.training.movie_management_system.exceptions.ResourceNotFoundException;
import com.usl.training.movie_management_system.mapper.LanguageRoleMapper;
import com.usl.training.movie_management_system.repository.LanguageRoleRepository;
import com.usl.training.movie_management_system.service.LanguageRoleService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@Service
public class LanguageRoleServiceImpl implements LanguageRoleService {

    private final LanguageRoleRepository languageRoleRepository;

    @Override
    public LanguageRoleDto getLanguageRoleById(Integer id) {

        LanguageRole languageRole = languageRoleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LanguageRole not found with id: " + id));
        return LanguageRoleMapper.mapToDto(languageRole);
    }





    @Override
    public List<LanguageRoleDto> getAllLanguageRoles() {
        List<LanguageRole> languageRoles = languageRoleRepository.findAll();
        return languageRoles.stream()
                .map(LanguageRoleMapper::mapToDto)
                .collect(Collectors.toList());

    }



    @Override
    public LanguageRoleDto createLanguageRole(LanguageRoleDto languageRoleDto) {
        LanguageRole languageRole = LanguageRoleMapper.mapToEntity(languageRoleDto);
        LanguageRole savedLanguageRole = languageRoleRepository.save(languageRole);
        return LanguageRoleMapper.mapToDto(savedLanguageRole);
    }



    @Override
    public LanguageRoleDto updateLanguageRole(Integer id, LanguageRoleDto languageRoleDto) {
        LanguageRole existingLanguageRole = languageRoleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LanguageRole not found with id: " + id));

        existingLanguageRole.setRoleId(languageRoleDto.getId());
        existingLanguageRole.setLanguageRole(languageRoleDto.getRoleName());

        LanguageRole updatedLanguageRole = languageRoleRepository.save(existingLanguageRole);
        return LanguageRoleMapper.mapToDto(updatedLanguageRole);


    }

    @Override
    public void deleteLanguageRole(Integer id) {
        languageRoleRepository.deleteById(id);

    }
}
