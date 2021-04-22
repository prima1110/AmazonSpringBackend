package com.example.AmazonMini.models;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends MongoRepository<Product,String> {

    List<Product> getByCategory(String category);
    List<Product> getByBestseller(Boolean bestseller);
}
