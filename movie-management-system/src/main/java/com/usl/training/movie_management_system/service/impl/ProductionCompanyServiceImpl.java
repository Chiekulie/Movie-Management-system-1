package com.usl.training.movie_management_system.service.impl;

import com.usl.training.movie_management_system.dto.ProductionCompanyDto;
import com.usl.training.movie_management_system.entity.ProductionCompany;
import com.usl.training.movie_management_system.exceptions.ResourceNotFoundException;
import com.usl.training.movie_management_system.mapper.ProductionCompanyMapper;
import com.usl.training.movie_management_system.repository.ProductionCompanyRepository;
import com.usl.training.movie_management_system.service.ProductionCompanyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductionCompanyServiceImpl implements ProductionCompanyService {

    private ProductionCompanyRepository pCompanyRepository;


    @Override
    public List<ProductionCompanyDto> getAllProductionCompanies() {
        List<ProductionCompany> companies = pCompanyRepository.findAll();

        return companies.stream().map(ProductionCompanyMapper::mapToProductionCompanyDto).collect(Collectors.toList());

    }

    @Override
    public ProductionCompanyDto getProductionCompanyById(Integer companyId) {
        ProductionCompany productionCompany = pCompanyRepository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("Company Not Found with id: " + companyId));
        return ProductionCompanyMapper.mapToProductionCompanyDto(productionCompany);
    }

    @Override
    public ProductionCompanyDto addProductionCompany(ProductionCompanyDto productionCompanyDto) {
        ProductionCompany productionCompany = new ProductionCompany();
        BeanUtils.copyProperties(productionCompanyDto, productionCompany, "companyId");
        return ProductionCompanyMapper.mapToProductionCompanyDto(pCompanyRepository.save(productionCompany));
    }

    @Override
    public ProductionCompanyDto updateProductionCompany(Integer companyId, ProductionCompanyDto productionCompanyDto) {
        ProductionCompany company = pCompanyRepository.findById(companyId)
                .map(existingCompany -> {
                    BeanUtils.copyProperties(productionCompanyDto, existingCompany, "companyId");
                    return pCompanyRepository.save(existingCompany);
                }).orElseThrow(() -> new ResourceNotFoundException("Company Not Found with id: " + companyId));
        return ProductionCompanyMapper.mapToProductionCompanyDto(company);
    }

    @Override
    public void deleteProductionCompany(Integer companyId) {
        ProductionCompany company = pCompanyRepository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundException("Company Not Found with id: " + companyId));
        pCompanyRepository.delete(company);
    }
}
