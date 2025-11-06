package com.interview.sarvika.tecnologies.generic_crud_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.interview.sarvika.tecnologies.generic_crud_api.dto.ProductRequestDTO;
import com.interview.sarvika.tecnologies.generic_crud_api.dto.ProductResponseDTO;
import com.interview.sarvika.tecnologies.generic_crud_api.entity.Product;
import com.interview.sarvika.tecnologies.generic_crud_api.exception.ResourceNotFoundException;
import com.interview.sarvika.tecnologies.generic_crud_api.mapper.ProductMapper;
import com.interview.sarvika.tecnologies.generic_crud_api.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ProductResponseDTO> getAll() {
        return productRepository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDTO getById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
        return mapper.toDTO(product);
    }

    @Override
    public ProductResponseDTO create(ProductRequestDTO dto) {
        Product product = mapper.toEntity(dto);
        return mapper.toDTO(productRepository.save(product));
    }

    @Override
    public ProductResponseDTO update(Long id, ProductRequestDTO dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        return mapper.toDTO(productRepository.save(product));
    }

    @Override
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found with id " + id);
        }
        productRepository.deleteById(id);
    }
    @Override
    public ProductResponseDTO create(ProductResponseDTO entity) { throw new UnsupportedOperationException(); }
    @Override
    public ProductResponseDTO update(Long id, ProductResponseDTO entity) { throw new UnsupportedOperationException(); }

	
}