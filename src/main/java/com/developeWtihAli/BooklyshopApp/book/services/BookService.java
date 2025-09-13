package com.developeWtihAli.BooklyshopApp.book.services;


import com.developeWtihAli.BooklyshopApp.book.entity.Book;

import java.util.List;

public interface BookService {

    Book addBook(Book book);
    Book updateBook(String id, Book book);
    void deleteBook(String id);
    Book getBookById(String id);
    List<Book> getAllBooks();
    List<Book> getBooksByCategoryId(String categoryId);

}
