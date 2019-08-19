package com.rotech.relationships.repositories.ProductsAndCategories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rotech.relationships.models.ProductsAndCatagories.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
	Product findByName(String name);
}
