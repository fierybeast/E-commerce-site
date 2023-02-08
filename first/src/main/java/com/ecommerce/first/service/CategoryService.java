package com.ecommerce.first.service;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.first.module.Category;
import com.ecommerce.first.repository.CategoryRepo;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepo categoryrepo;
	
	//it is a getting a category and saving it.
	public void createCategory(Category category) {
		categoryrepo.save(category);
	}
	
	public List<Category> listCategory(){
		return categoryrepo.findAll();
	}
	
	public void editCategory(int categoryId,Category updateCategory) {
		Category category = categoryrepo.getById(categoryId);
		category.setCategoryName(updateCategory.getCategoryName());
		category.setDescription(updateCategory.getDescription());
		category.setImageUrl(updateCategory.getImageUrl());
		categoryrepo.save(category);
	}

	public boolean findById(int categoryId) {
		return categoryrepo.findById(categoryId).isPresent();
	}

	public void deleteCategory(int categoryId) {
		categoryrepo.deleteById(categoryId);
		
	}

}
