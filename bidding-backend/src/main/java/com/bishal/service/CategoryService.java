package com.bishal.service;

import java.util.List;

import com.bishal.model.Category;


public interface CategoryService {
	

	
	
	public List<Category> getAllCategory();
	public Category addCategory(Category category);
	public Category updateCategory(Category category, int id) throws Exception;
	public void deleteCategory(int id);


}
