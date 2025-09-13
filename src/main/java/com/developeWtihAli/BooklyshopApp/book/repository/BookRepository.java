package com.developeWtihAli.BooklyshopApp.book.repository;

import com.developeWtihAli.BooklyshopApp.book.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book , String> {
    List<Book> findByCategoryId(String categoryId);
}
