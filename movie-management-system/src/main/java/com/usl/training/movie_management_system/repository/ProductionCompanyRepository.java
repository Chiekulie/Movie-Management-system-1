package com.usl.training.movie_management_system.repository;

import com.usl.training.movie_management_system.entity.ProductionCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionCompanyRepository extends JpaRepository<ProductionCompany, Integer> {
    ProductionCompany findByCompanyName(String name);
}
