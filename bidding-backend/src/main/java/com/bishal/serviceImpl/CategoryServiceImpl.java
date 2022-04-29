
package com.bishal.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishal.model.Category;

import com.bishal.repo.CategoryRepo;
import com.bishal.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public List<Category> getAllCategory() {
		
		return categoryRepo.findAll();
	}

	@Override
	public Category addCategory(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public Category updateCategory(Category category, int id) throws Exception {
		Category existingCategory = categoryRepo.findById(id).orElseThrow(()->new Exception("Id not found"));
		existingCategory.setCategoryName(category.getCategoryName());
		return existingCategory;
	}

	@Override
	public void deleteCategory(int id) {
		categoryRepo.deleteById(id);
		
	}

	
}
