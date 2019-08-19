package com.rotech.relationships.services.ProductsAndCategories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rotech.relationships.models.ProductsAndCatagories.Category;
import com.rotech.relationships.models.ProductsAndCatagories.Product;
import com.rotech.relationships.repositories.ProductsAndCategories.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository repo;
	public CategoryService(CategoryRepository repo) {
		this.repo = repo;
	}
	public List<Category> findAll(){
		return repo.findAll();
	}
	public Category findByName(String name) {
		return repo.findByName(name);
	}
	public Category findById(Long id) {
		Optional<Category> maybe = repo.findById(id);
		if(maybe.isPresent()) {
			return maybe.get();
		}else {
			return null;
		}
	}
	public Category create(Category category) {
		return repo.save(category);
	}
}
