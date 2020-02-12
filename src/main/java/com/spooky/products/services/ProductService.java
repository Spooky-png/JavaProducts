package com.spooky.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spooky.products.models.Category;
import com.spooky.products.models.Product;
import com.spooky.products.repositories.CategoryRepository;
import com.spooky.products.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	
	public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}
	public List<Product> allProducts(){
		return productRepository.findAll();
	}
	public List<Category> allCategories(){
		return categoryRepository.findAll();
	}
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else {
			return null;
		}
	}
	public Category createCategory(Category c) {
		return categoryRepository.save(c);
	}
	public Product createProduct(Product p) {
		return productRepository.save(p);
	}
}
