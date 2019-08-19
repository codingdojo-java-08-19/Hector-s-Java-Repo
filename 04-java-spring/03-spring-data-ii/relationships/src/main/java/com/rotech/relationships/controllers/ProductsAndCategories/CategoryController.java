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
@RequestMapping("/categories")
public class CategoryController {
	private final CategoryService service;
	private final ProductService proServ;
	public CategoryController(CategoryService service, ProductService proServ) {
		this.service = service;
		this.proServ = proServ;
	}
	@GetMapping("/new")
	public String displayNewCate(@ModelAttribute("category") Category category) {
		return "ProductsAndCategories/Categories/NewCatgories.jsp";
	}
	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(!result.hasErrors()) {
			Category newCat = service.create(category);
			
			return "redirect:/categories/"+ newCat.getId();
		}
		return "ProductsAndCategories/Categories/NewCatgories.jsp";
	}
	
	@GetMapping("/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
		Category cat = service.findById(id);
		List<Product> products = proServ.findAll();
		model.addAttribute("cat", cat);
		model.addAttribute("catProds", cat.getProducts());
		model.addAttribute("products",products);
		return "ProductsAndCategories/Categories/ShowCategory.jsp";
	}
	@PostMapping("/{id}")
	public String addProd(@PathVariable("id") Long id, @RequestParam("name") String name) {
		Category cat = service.findById(id);
		Product product = proServ.findByName(name);
		List<Product> products = new ArrayList<Product>();
		products.add(product);
		products.addAll(cat.getProducts());
		cat.setProducts(products);
		service.create(cat);
		
		return "redirect:/categories/"+id;
	}

}
