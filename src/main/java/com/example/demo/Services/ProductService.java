package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.ProductRepository;

import java.util.List;

import com.example.demo.Core.Utilities.results.DataResult;
import com.example.demo.Core.Utilities.results.SuccessDataResult;
import com.example.demo.Models.Product;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public DataResult<List<Product>> getAllProducts() {
        return new SuccessDataResult<List<Product>>(this.productRepository.findAll(), "Data Listelendi");
    }
    
}

