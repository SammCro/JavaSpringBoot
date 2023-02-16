package com.example.demo.Repositories;
import com.example.demo.Models.Product;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product getByProductName(String productName);
	  
    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
    
    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
    
    List<Product> getByCategoryIn(List<Integer> categories);
    
    List<Product> getByProductNameContains(String productName);
    
    List<Product> getByProductNameStartsWith(String productName);
    
    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
    List<Product> getByProductNameAndCategory(String productName, int categoryId);
    
}
