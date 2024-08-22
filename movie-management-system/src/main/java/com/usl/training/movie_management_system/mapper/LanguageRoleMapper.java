package com.usl.training.movie_management_system.mapper;

import com.usl.training.movie_management_system.dto.LanguageRoleDto;
import com.usl.training.movie_management_system.entity.LanguageRole;
public class LanguageRoleMapper {

    public static LanguageRoleDto mapToDto(LanguageRole languageRole) {
        return new LanguageRoleDto(languageRole.getRoleId(), languageRole.getLanguageRole());
    }

    public static LanguageRole mapToEntity(LanguageRoleDto languageRoleDto) {
        return new LanguageRole(languageRoleDto.getId(), languageRoleDto.getRoleName());
    }




}
