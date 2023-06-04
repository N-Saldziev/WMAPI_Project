package com.example.wmapi.controllers;

import com.example.wmapi.models.Product;
import com.example.wmapi.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> list(){
        return productRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{product_id}")
    public Product get (@PathVariable Long product_id){
        return productRepository.getOne(product_id);
    }

    @PostMapping
    public Product create(@RequestBody final Product product){
        return productRepository.saveAndFlush(product);
    }
    @RequestMapping(value = "{product_id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long product_id){
        productRepository.deleteById(product_id);
    }
    @RequestMapping(value = "{product_id}", method = RequestMethod.PUT)
    public Product update(@PathVariable Long product_id, @RequestBody Product product){
        //Put Vs Patch
        Product existingProduct = productRepository.getOne(product_id);
        BeanUtils.copyProperties(product, existingProduct,"product_id");
        return productRepository.saveAndFlush(existingProduct);
    }
}
