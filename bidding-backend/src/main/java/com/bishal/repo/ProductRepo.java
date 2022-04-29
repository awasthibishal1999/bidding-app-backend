package com.bishal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bishal.model.Product;
import org.springframework.data.rest.core.annotation.RestResource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
	
//	@RestResource(path = "categoryid")
//	Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);
//	
//	@RestResource(path = "searchbykeyword")
//	Page<Product> findByNameContaining(@Param("name") String keyword, Pageable pageable);

}
