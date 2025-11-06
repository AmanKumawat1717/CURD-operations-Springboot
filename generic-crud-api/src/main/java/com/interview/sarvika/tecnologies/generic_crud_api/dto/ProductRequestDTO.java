package com.interview.sarvika.tecnologies.generic_crud_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {

    @NotBlank(message = "Product name is required")
    @Size(min = 2, max = 100)
    private String name;

    @Size(max = 255)
    private String description;

    @Min(value = 0, message = "Price must be positive")
    private double price;

}