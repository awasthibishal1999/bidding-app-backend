package com.bishal.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishal.model.Product;
import com.bishal.repo.ProductRepo;
import com.bishal.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepo productRepo;



	@Override
	public List<Product> getAllProducts() {
		
		return productRepo.findAll();
	
	}

	@Override
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public Product getProductById(int id) throws Exception {
		return productRepo.findById(id).orElseThrow(() -> new Exception());
	}

	@Override
	public Product updateProduct(Product product, int id) throws Exception {
		Product updatedProduct = productRepo.findById(id).orElseThrow(() -> new Exception("id not found"));
		updatedProduct.setProductName(product.getProductName());
		updatedProduct.setPrice(product.getPrice());
		updatedProduct.setDescription(product.getDescription());
		return productRepo.save(updatedProduct);
	}

	@Override
	public void deleteProduct(int id) {
		productRepo.deleteById(id);
		
	}

}
