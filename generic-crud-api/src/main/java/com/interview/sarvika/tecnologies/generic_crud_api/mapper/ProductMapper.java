package com.interview.sarvika.tecnologies.generic_crud_api.mapper;

import org.springframework.stereotype.Component;

import com.interview.sarvika.tecnologies.generic_crud_api.dto.ProductRequestDTO;
import com.interview.sarvika.tecnologies.generic_crud_api.dto.ProductResponseDTO;
import com.interview.sarvika.tecnologies.generic_crud_api.entity.Product;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequestDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        return product;
    }

    public ProductResponseDTO toDTO(Product product) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        return dto;
    }
}