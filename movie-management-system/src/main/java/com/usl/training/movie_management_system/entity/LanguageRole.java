package com.usl.training.movie_management_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "language_role")
public class LanguageRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer RoleId;
    private String languageRole;
}
