package com.usl.training.movie_management_system.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "language")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer languageId;
    @Column(name = "language_code", nullable = false)
    @Size(min = 2, max = 2, message = "ISO code must be exactly 2 characters long")
    private String languageCode;
    @Column(name = "language_name", nullable = false)
    private String languageName;
}
