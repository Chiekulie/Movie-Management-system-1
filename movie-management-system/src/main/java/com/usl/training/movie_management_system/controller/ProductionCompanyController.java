package com.usl.training.movie_management_system.controller;

import com.usl.training.movie_management_system.dto.ProductionCompanyDto;
import com.usl.training.movie_management_system.service.ProductionCompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/movies/productions")
public class ProductionCompanyController {
    private ProductionCompanyService productionCompanyService;

    @GetMapping
    public ResponseEntity<List<ProductionCompanyDto>> getAllProductionCompanies() {
        return ResponseEntity.ok(productionCompanyService.getAllProductionCompanies());
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductionCompanyDto> getProductionCompanyById(@PathVariable Integer id) {
        return ResponseEntity.ok(productionCompanyService.getProductionCompanyById(id));
    }

    @PostMapping
    public ResponseEntity<ProductionCompanyDto> createProductionCompany
            (@RequestBody ProductionCompanyDto productionCompanyDto) {
        return new ResponseEntity<>(productionCompanyService.addProductionCompany(productionCompanyDto), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductionCompanyDto> updateProductionCompany
            (@PathVariable Integer id,
             @RequestBody ProductionCompanyDto productionCompanyDto) {
        return ResponseEntity.ok(productionCompanyService.updateProductionCompany(id, productionCompanyDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProductionCompany(@PathVariable Integer id) {
        productionCompanyService.deleteProductionCompany(id);
        return ResponseEntity.ok("Production company deleted successfully.");
    }
}
