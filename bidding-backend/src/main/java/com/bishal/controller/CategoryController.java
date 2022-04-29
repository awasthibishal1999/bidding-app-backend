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
import com.bishal.service.CategoryService;

@RestController
@RequestMapping("/v1")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	

	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getAllCategory() {

		List<Category> allCategories = categoryService.getAllCategory();

		return new ResponseEntity<>(allCategories, HttpStatus.OK);
	}
	
	@PostMapping("/add-new-categories")
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		
		Category addNew = categoryService.addCategory(category);
		return new ResponseEntity<>(addNew, HttpStatus.CREATED);
	}
	
	@PutMapping("/categories/{id}")
	public ResponseEntity<Category> addCategory(@PathVariable("id") Integer id,@RequestBody Category category) throws Exception{
		return new ResponseEntity<>(categoryService.updateCategory(category, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/categories/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable("id") Integer id) throws Exception{
		categoryService.deleteCategory(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
