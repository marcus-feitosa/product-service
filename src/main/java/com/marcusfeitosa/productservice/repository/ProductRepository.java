package com.marcusfeitosa.productservice.repository;

import com.marcusfeitosa.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
