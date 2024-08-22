package com.usl.training.movie_management_system.controller;

import com.usl.training.movie_management_system.dto.LanguageRoleDto;
import com.usl.training.movie_management_system.service.LanguageRoleService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/api/movies/languageRoles")

public class LanguageRoleController {

    private final LanguageRoleService languageRoleService;




    @GetMapping("{id}")
    public ResponseEntity<LanguageRoleDto> getLanguageRoleById(@PathVariable Integer id) {
        LanguageRoleDto languageRoleDto = languageRoleService.getLanguageRoleById(id);
        return ResponseEntity.ok(languageRoleDto);

    }


    @GetMapping
    public ResponseEntity<List<LanguageRoleDto>> getAllLanguageRoles() {
        List<LanguageRoleDto> languageRoleDto = languageRoleService.getAllLanguageRoles();
        return ResponseEntity.ok(languageRoleDto);

    }


    @PutMapping("{id}")
    public ResponseEntity<LanguageRoleDto> updateLanguageRole(
            @PathVariable Integer id,
            @RequestBody LanguageRoleDto languageRoleDto) {
        LanguageRoleDto updatedLanguageRole = languageRoleService.updateLanguageRole(id, languageRoleDto);
        return ResponseEntity.ok(updatedLanguageRole);

    }



    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteLanguageRole(@PathVariable Integer id) {
        languageRoleService.deleteLanguageRole(id);
        return ResponseEntity.noContent().build();
    }







}
