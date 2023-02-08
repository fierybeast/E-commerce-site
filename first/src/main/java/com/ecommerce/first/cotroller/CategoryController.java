package com.ecommerce.first.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.first.common.ApiResponse;
import com.ecommerce.first.module.Category;
import com.ecommerce.first.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryservice;
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createCategory(@RequestBody Category category) {
		categoryservice.createCategory(category);
		return new ResponseEntity<>(new ApiResponse(true,"A new category is created"),HttpStatus.CREATED);
	}
	
	@GetMapping("/list")
	public List<Category> getall(){
		return categoryservice.listCategory();
		
	}
	
	@PostMapping("/update/{categoryId}")
	public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryId") int categoryId, @RequestBody Category category) {
		if(!categoryservice.findById(categoryId)){
			return new ResponseEntity<>(new ApiResponse(false,"category does not exist"),HttpStatus.NOT_FOUND);
		}
		categoryservice.editCategory(categoryId,category);
		return new ResponseEntity<>(new ApiResponse(true,"update was successful"),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable int categoryId){
		if (!categoryservice.findById(categoryId)) {
			return new ResponseEntity<>(new ApiResponse(false, "Category does not exist"),HttpStatus.NOT_FOUND);
		}
		categoryservice.deleteCategory(categoryId);
		return new ResponseEntity<>(new ApiResponse(true, "Category successfully deleted"),HttpStatus.OK);
	}
	

}
