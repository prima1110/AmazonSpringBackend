package com.example.AmazonMini.services;

import com.example.AmazonMini.models.Product;
import com.example.AmazonMini.models.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public void addProduct(Product product)
    {
        repo.insert(product);
    }
    public Optional<Product> getAProduct(String id)
    {
        return repo.findById(id);
    }

    public void deleteProduct(String id)
    {
        repo.deleteById(id);
    }

    public List<Product> productCategory(String category)
    {
        return repo.getByCategory(category);
    }

    public List<Product> bestsellerProduct(Boolean bestseller)
    {
        return repo.getByBestseller(bestseller);
    }

    public List<Product> getProducts()
    {
        return repo.findAll();
    }
}
