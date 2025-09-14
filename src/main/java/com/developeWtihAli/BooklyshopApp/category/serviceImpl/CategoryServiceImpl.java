package com.developeWtihAli.BooklyshopApp.category.serviceImpl;


import com.developeWtihAli.BooklyshopApp.category.entity.Category;
import com.developeWtihAli.BooklyshopApp.category.repository.CategoryRepository;
import com.developeWtihAli.BooklyshopApp.category.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {


    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public Category addCategory(Category category) {
        category.setCreatedAt(LocalDateTime.now());
        category.setUpdatedAt(LocalDateTime.now());
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(String categoryId, Category category) {
        Category existingCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + categoryId));

        if (category.getCategoryName() != null) existingCategory.setCategoryName(category.getCategoryName());
        if (category.getCategoryImg() != null) existingCategory.setCategoryImg(category.getCategoryImg());
        if (category.getDescription() != null) existingCategory.setDescription(category.getDescription());
        if (category.getStatus() != null) existingCategory.setStatus(category.getStatus());
        if (category.getType() != null) existingCategory.setType(category.getType());

        existingCategory.setUpdatedAt(LocalDateTime.now());
        return categoryRepository.save(existingCategory);
    }

    @Override
    public void deleteCategory(String categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public Category getCategoryById(String categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + categoryId));
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> getBookCategories() {
        return categoryRepository.findAll().stream()
                .filter(category -> "book".equals(category.getType()))
                .toList();
    }

    @Override
    public List<Category> getAccessoryCategories() {
        return categoryRepository.findAll().stream()
                .filter(category -> "accessory".equals(category.getType()))
                .toList();
    }
}
