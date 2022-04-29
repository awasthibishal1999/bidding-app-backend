package com.bishal.service;

import java.util.List;


import com.bishal.model.Product;

public interface ProductService {
	public List<Product> getAllProducts();
	public Product addProduct(Product product);
	public Product getProductById(int id) throws Exception;
	public Product updateProduct(Product product, int id) throws Exception;
	public void deleteProduct(int id);
	
	
}
