package com.usl.training.movie_management_system.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "country")
@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer countryId;
    @Column(name = "country_iso_code", nullable = false)
    @Size(min = 2, max = 2, message = "ISO code must be exactly 2 characters long")
    private String countryIsoCode;
    @Column(name = "country_name", nullable = false)
    private String countryName;

}
