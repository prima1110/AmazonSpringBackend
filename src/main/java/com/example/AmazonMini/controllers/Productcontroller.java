package com.example.AmazonMini.controllers;

import com.example.AmazonMini.DataResponse;
import com.example.AmazonMini.models.Product;
import com.example.AmazonMini.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@CrossOrigin
@RestController
public class Productcontroller {

    @Autowired
    private ProductService proService;

    @PostMapping(value = "/products/category",consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity productCategory(@RequestBody Product product)
    {
        var DataResponse = new DataResponse(proService.productCategory(product.getCategory()), "Product by"+product.getCategory());
        return new ResponseEntity(DataResponse, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity getAProduct(@PathVariable("id") String id)
    {

        var dataResponse = new DataResponse(Collections.singletonList(proService.getAProduct(id)),"Single Product");

        return new ResponseEntity(dataResponse,HttpStatus.OK);
    }

    @PostMapping(value = "/products/add",consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity addProduct(@RequestBody Product product)
    {

        proService.addProduct(product);

        return new ResponseEntity(product,HttpStatus.OK);

    }


    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") String id)
    {
        proService.deleteProduct(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/products/bestseller")
    public ResponseEntity getBestsellerProduct()
    {
        var dataResponse = new DataResponse(proService.bestsellerProduct(true), "Products by bestseller");
        return new ResponseEntity(dataResponse, HttpStatus.OK);
    }

    @GetMapping("/products/all")
    public ResponseEntity getProducts()
    {
        var dataResponse = new DataResponse(proService.getProducts(), "All Products");
        return new ResponseEntity(dataResponse,HttpStatus.OK);
    }
}
