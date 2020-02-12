package com.spooky.products.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spooky.products.models.Category;
import com.spooky.products.models.Product;
import com.spooky.products.services.ProductService;

@RestController
public class ProductApi {
	private final ProductService productService;
	public ProductApi(ProductService productService) {
		this.productService = productService;
	}
	@GetMapping("/api/products")
	public List<Product> index(){
		return productService.allProducts();
	}
	@GetMapping("/api/categories")
	public List<Category> index2(){
		return productService.allCategories();
	}
	@PostMapping(value="/api/products")
	public Product create(@RequestParam(value="name") String name,@RequestParam(value="description") String description,@RequestParam(value="price") double price,@RequestParam(value="category") List<Category> category) {
		Product product = new Product(name, description,price,category);
		return productService.createProduct(product);
	}
	@PostMapping(value="/api/categories")
	public Category create(@RequestParam(value="name") String name,@RequestParam(value="product") List<Product> product) {
		Category category = new Category(name, product);
		return productService.createCategory(category);
	}

}
