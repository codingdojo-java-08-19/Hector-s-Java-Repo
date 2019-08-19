package com.rotech.relationships.repositories.ProductsAndCategories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rotech.relationships.models.ProductsAndCatagories.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();
	Category findByName(String name);
}
