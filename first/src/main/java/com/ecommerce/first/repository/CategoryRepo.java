package com.ecommerce.first.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.first.module.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
