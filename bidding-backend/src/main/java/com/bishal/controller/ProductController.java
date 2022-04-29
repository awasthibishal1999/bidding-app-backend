package com.bishal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bishal.model.Category;
import com.bishal.model.Product;
import com.bishal.repo.CategoryRepo;
import com.bishal.service.ProductService;

@RestController
@RequestMapping("/v1")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> allProducts = productService.getAllProducts();
		return new ResponseEntity<>(allProducts, HttpStatus.OK);

	}

	// get single product
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Integer id) throws Exception {
		return new ResponseEntity<Product>(productService.getProductById(id), HttpStatus.OK);
	}

	// add a new product
	@PostMapping("/add-new-product")
	public ResponseEntity<Product> addNewProduct(@RequestBody Product product) {
		Category cat = categoryRepo.findById(product.getCategory().getId())
				.orElseThrow(() -> new RuntimeException("invalid category id"));
		product.setCategory(cat);
		Product newProduct = productService.addProduct(product);
		return new ResponseEntity<Product>(newProduct, HttpStatus.CREATED);
	}

	// update the product
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> addNewProduct(@PathVariable("id") Integer id, @RequestBody Product product)
			throws Exception {
		return new ResponseEntity<Product>(productService.updateProduct(product, id), HttpStatus.OK);
	}

//	delete product
	@DeleteMapping("/products/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id) {
		productService.deleteProduct(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
