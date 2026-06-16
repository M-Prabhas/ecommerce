package com.ecommerce.productservice.DTO;


import java.math.BigDecimal;

import com.ecommerce.productservice.model.Product.ProductBuilder;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private String name;
    private String description;
    private BigDecimal price;
    }
