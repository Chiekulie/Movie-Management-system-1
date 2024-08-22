package com.usl.training.movie_management_system.mapper;

import com.usl.training.movie_management_system.dto.ProductionCompanyDto;
import com.usl.training.movie_management_system.entity.ProductionCompany;
import org.springframework.stereotype.Component;

@Component
public class ProductionCompanyMapper {
    public static ProductionCompany mapToProductionCompany(ProductionCompanyDto productionCompanyDto) {
        if (productionCompanyDto == null) {
            return null;
        }

        ProductionCompany productionCompany = new ProductionCompany();

        productionCompany.setCompanyId(productionCompanyDto.getCompanyId());
        productionCompany.setCompanyName(productionCompanyDto.getCompanyName());
        return productionCompany;

    }


    public static ProductionCompanyDto mapToProductionCompanyDto(ProductionCompany productionCompany) {
        if (productionCompany == null) {
            return null;
        }

        ProductionCompanyDto productionCompanyDto = new ProductionCompanyDto();
        productionCompanyDto.setCompanyId(productionCompany.getCompanyId());
        productionCompanyDto.setCompanyName(productionCompany.getCompanyName());
        return productionCompanyDto;
    }
}
