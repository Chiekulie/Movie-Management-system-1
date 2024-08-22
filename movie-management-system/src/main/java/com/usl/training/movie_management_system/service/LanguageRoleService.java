package com.usl.training.movie_management_system.service;

import com.usl.training.movie_management_system.dto.LanguageRoleDto;

import java.util.List;

public interface LanguageRoleService {

    LanguageRoleDto getLanguageRoleById(Integer id);
    List<LanguageRoleDto> getAllLanguageRoles();
    LanguageRoleDto createLanguageRole(LanguageRoleDto languageRoleDto);
    LanguageRoleDto updateLanguageRole(Integer id, LanguageRoleDto languageRoleDto);
    void deleteLanguageRole(Integer id);


}
