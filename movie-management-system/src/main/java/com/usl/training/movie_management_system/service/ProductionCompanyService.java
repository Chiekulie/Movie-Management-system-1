package com.usl.training.movie_management_system.service;

import com.usl.training.movie_management_system.dto.ProductionCompanyDto;

import java.util.List;

public interface ProductionCompanyService {
    List<ProductionCompanyDto> getAllProductionCompanies();
    ProductionCompanyDto getProductionCompanyById(Integer companyId);
    ProductionCompanyDto addProductionCompany(ProductionCompanyDto productionCompanyDto);
    ProductionCompanyDto updateProductionCompany(Integer companyId, ProductionCompanyDto productionCompanyDto);
    void deleteProductionCompany(Integer companyId);
}
