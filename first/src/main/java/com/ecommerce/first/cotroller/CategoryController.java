package com.ecommerce.first.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.first.module.Category;
import com.ecommerce.first.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryservice;
	
	@PostMapping("/create")
	public String createCategory(@RequestBody Category category) {
		categoryservice.createCategory(category);
		return "successfully created";
	}
	
	@GetMapping("/list")
	public List<Category> getall(){
		return categoryservice.listCategory();
		
	}

}
