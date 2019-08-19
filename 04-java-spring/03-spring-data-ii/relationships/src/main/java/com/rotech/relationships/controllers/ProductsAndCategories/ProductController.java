package com.rotech.relationships.controllers.ProductsAndCategories;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rotech.relationships.models.ProductsAndCatagories.Category;
import com.rotech.relationships.models.ProductsAndCatagories.Product;
import com.rotech.relationships.services.ProductsAndCategories.CategoryService;
import com.rotech.relationships.services.ProductsAndCategories.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	private final ProductService service;
	private final CategoryService catServ;
	public ProductController(ProductService service, CategoryService catServ) {
		this.service = service;
		this.catServ = catServ;
	}
	
	@GetMapping("/new")
	public String displayNewProduct(@ModelAttribute("product") Product product) {
		
		return "ProductsAndCategories/Products/NewProduct.jsp";
	}
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(!result.hasErrors()) {
			Product newProduct = service.create(product);
			
			return "redirect:/products/" + newProduct.getId();
		}
		return "ProductsAndCategories/Products/NewProduct.jsp";
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model model,@ModelAttribute("updateProduct") Product UpdateProduct) {
			Product product = service.findById(id);
			List<Category> categories = catServ.findAll();
			
			model.addAttribute("product", product);
			model.addAttribute("categories", categories);
			model.addAttribute("prodCats", product.getCategories());
		return "ProductsAndCategories/Products/ShowProduct.jsp";
	}
	@PostMapping("/{id}")
	public String addCat(@PathVariable("id") Long id, @RequestParam("name") String name) {
		Product product = service.findById(id);
		Category cat = catServ.findByName(name);
		List<Category> categories = new ArrayList<Category>();
		categories.add(cat);
		categories.addAll(product.getCategories());
		product.setCategories(categories);
		service.create(product);
		
		return "redirect:/products/"+ id;
	}
}
