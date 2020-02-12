package com.spooky.products.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spooky.products.models.Category;
import com.spooky.products.models.Product;
import com.spooky.products.repositories.CategoryRepository;
import com.spooky.products.repositories.ProductRepository;
import com.spooky.products.services.ProductService;

@Controller
public class ProductController {
	private final ProductService productService;
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	
	public ProductController(ProductService productService,ProductRepository productRepository,CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
		this.productService = productService;
	}
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("products") Product p, Model model) {
		List<Product>allProducts = productService.allProducts();
		model.addAttribute("product", allProducts);
		return "/products/newProduct.jsp";
	}
	@PostMapping(value="/products/new")
	public String createProduct(@Valid @ModelAttribute("products") Product p, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Product>allProducts = productService.allProducts();
			model.addAttribute("product", allProducts);
			return "/products/newProduct.jsp";
		} else {
			productService.createProduct(p);
			return "redirect:/products";
		}
	}
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("categories") Category c, Model model) {
		List<Category>allCategories = productService.allCategories();
		model.addAttribute("category", allCategories);
		return "/products/newCategory.jsp";
	}
	@PostMapping(value="/products/new")
	public String createProduct(@Valid @ModelAttribute("products") Category c, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Category>allCategories = productService.allCategories();
			model.addAttribute("category", allCategories);
			return "/products/newCategory.jsp";
		} else {
			productService.createCategory(c);
			return "redirect:/products";
		}
	}
	@GetMapping("/products/{id}")
	public String view(@PathVariable("id") Long id, Model model) {
		Product product = productService.findProduct(id);
		model.addAttribute("product", product);
		return "/products/viewProduct.jsp";
	}
	@GetMapping("/categories/{id}")
	public String view2(@PathVariable("id") Long id, Model model) {
		Category category = productService.findCategory(id);
		model.addAttribute("category", category);
		return "/products/viewCategory.jsp";
	}
	public ProductRepository getProductRepository() {
		return productRepository;
	}
	public CategoryRepository getCategoryRepository() {
		return categoryRepository;
	}

}
