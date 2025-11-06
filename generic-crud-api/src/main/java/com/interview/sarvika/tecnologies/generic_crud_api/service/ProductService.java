package com.interview.sarvika.tecnologies.generic_crud_api.service;

import com.interview.sarvika.tecnologies.generic_crud_api.dto.ProductRequestDTO;
import com.interview.sarvika.tecnologies.generic_crud_api.dto.ProductResponseDTO;

public interface ProductService extends CrudService<ProductResponseDTO, Long> {
    ProductResponseDTO create(ProductRequestDTO dto);
    ProductResponseDTO update(Long id, ProductRequestDTO dto);
}
