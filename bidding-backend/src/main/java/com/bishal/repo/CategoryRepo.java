package com.bishal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.bishal.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
