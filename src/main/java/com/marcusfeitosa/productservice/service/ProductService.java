package com.marcusfeitosa.productservice.service;

import com.marcusfeitosa.productservice.dto.ProductDTO;
import com.marcusfeitosa.productservice.dto.ProductResponse;
import com.marcusfeitosa.productservice.model.Product;
import com.marcusfeitosa.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    public void createProduct(ProductDTO productDTO){
        Product product = Product.builder()
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts(){
      List<Product> products = productRepository.findAll();
      return products.stream().map(this::mapToProductResponde).toList();
    }
    private ProductResponse mapToProductResponde(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
