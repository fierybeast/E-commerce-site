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

}
