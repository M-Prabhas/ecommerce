package com.ecommerce.productservice.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import com.ecommerce.productservice.DTO.ProductRequest;
import com.ecommerce.productservice.DTO.ProductResponse;
import com.ecommerce.productservice.model.Product;
import com.ecommerce.productservice.repository.ProductRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {


    private final ProductRepository productRepository;
    
    
    public void createProduct(ProductRequest productRequest) {
       Product product=Product.builder()
                      .name(productRequest.getName())  
                      .description(productRequest.getDescription())     
                      .price(productRequest.getPrice())
                      .build();
      productRepository.save(product);
      log.info("Product {} is saved",product.getName());   
     }


      public List<ProductResponse> getAllProducts(){
          List<Product> products=productRepository.findAll();
          return products.stream().map(product->mapToProductResponse(product)).toList();
      }

      private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder().name(product.getName())
                                        .description(product.getDescription())
                                        .price(product.getPrice())
                                        .build();
      }


     
    }
