package com.marcusfeitosa.productservice.controller;

import com.marcusfeitosa.productservice.dto.ProductDTO;
import com.marcusfeitosa.productservice.dto.ProductResponse;
import com.marcusfeitosa.productservice.model.Product;
import com.marcusfeitosa.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductDTO productDTO){
        productService.createProduct(productDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }
}