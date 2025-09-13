package com.developeWtihAli.BooklyshopApp.category.repository;


import com.developeWtihAli.BooklyshopApp.category.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface CategoryRepository extends MongoRepository<Category, String> {

}
