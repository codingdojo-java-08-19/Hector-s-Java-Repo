package com.rotech.relationships.services.ProductsAndCategories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rotech.relationships.models.ProductsAndCatagories.Product;
import com.rotech.relationships.repositories.ProductsAndCategories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository repo;
	public ProductService(ProductRepository repo) {
		this.repo = repo;
	}
	
	public List<Product> findAll(){
		return repo.findAll();
	}
	public Product findByName(String name) {
		return repo.findByName(name);
	}
	public Product findById(Long id) {
		Optional<Product> maybe = repo.findById(id);
		if(maybe.isPresent()) {
			return maybe.get();
		}else {
			return null;
		}
	}
	public Product create(Product product) {
		return repo.save(product);
	}
}
