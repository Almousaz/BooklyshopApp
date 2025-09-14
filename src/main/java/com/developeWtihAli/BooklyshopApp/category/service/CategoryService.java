package com.developeWtihAli.BooklyshopApp.category.service;


import com.developeWtihAli.BooklyshopApp.category.entity.Category;

import java.util.List;

public interface CategoryService {

    Category addCategory(Category category);
    Category updateCategory(String categoryId, Category category);
    void deleteCategory(String categoryId);
    Category getCategoryById(String categoryId);
    List<Category> getAllCategory();
    List<Category> getBookCategories();
    List<Category> getAccessoryCategories();


}
