package com.example.demo.Repositories;
import com.example.demo.Models.Product;
import com.example.demo.Models.DTOS.ProductWithCategoryDTO;

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
    
//     @Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto"
//     + "(p.id, p.productName, c.categoryName) "
//     + "From Category c Inner Join c.products p")
// List<ProductWithCategoryDTO> getProductWithCategoryDetails();

}
