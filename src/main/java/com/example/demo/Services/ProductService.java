package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.ProductRepository;

import java.util.List;

import com.example.demo.Core.Utilities.results.DataResult;
import com.example.demo.Core.Utilities.results.SuccessDataResult;
import com.example.demo.Core.Utilities.results.Result;
import com.example.demo.Core.Utilities.results.SuccessResult;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.Models.Product;


@Service
public class ProductService{

	private ProductRepository ProductRepository;
	
	@Autowired
	public ProductService(ProductRepository ProductRepository) {
		super();
		this.ProductRepository = ProductRepository;
	}


	public DataResult<List<Product>> getAll() {
		    
			return new SuccessDataResult<List<Product>>
			(this.ProductRepository.findAll(),"Data listelendi");			
				
	}

	
	public Result add(Product product) {
		this.ProductRepository.save(product);
		return new SuccessResult("Ürün eklendi");
	}

	
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>
		(this.ProductRepository.getByProductName(productName),"Data listelendi");	
	}


	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		//business codes
		
		return new SuccessDataResult<Product>
		(this.ProductRepository.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data listelendi");
	}


	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.ProductRepository.getByProductNameOrCategory_CategoryId(productName, categoryId),"Data listelendi");
	}


	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>
		(this.ProductRepository.getByCategoryIn(categories),"Data listelendi");
	}


	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.ProductRepository.getByProductNameContains(productName),"Data listelendi");
	}


	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>
		(this.ProductRepository.getByProductNameStartsWith(productName),"Data listelendi");
	}

	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>
		(this.ProductRepository.getByNameAndCategory(productName,categoryId),"Data listelendi");
	}


	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		return new SuccessDataResult<List<Product>>
		(this.ProductRepository.findAll(pageable).getContent());
	}


	public DataResult<List<Product>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"productName");
		return new SuccessDataResult<List<Product>>
		(this.ProductRepository.findAll(sort),"Başarılı");
	}


}
