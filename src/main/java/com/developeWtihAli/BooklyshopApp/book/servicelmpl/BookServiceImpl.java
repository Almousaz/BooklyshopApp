package com.developeWtihAli.BooklyshopApp.book.servicelmpl;


import com.developeWtihAli.BooklyshopApp.book.entity.Book;
import com.developeWtihAli.BooklyshopApp.book.repository.BookRepository;
import com.developeWtihAli.BooklyshopApp.book.services.BookService;
import com.developeWtihAli.BooklyshopApp.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;



@Service
public class BookServiceImpl implements BookService {


    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);


    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;



    @Override
    public Book addBook(Book book) {
        Book savedBook = bookRepository.save(book);
        logger.info("Added book: {}", savedBook.getBookId());
        return savedBook;
    }

    @Override
    public Book updateBook(String id, Book book) {
        Book existingBook = bookRepository.findById(id).orElse(null);
        if (existingBook == null) return null;

        // Minimal update: only title and price
        if (book.getTitle() != null) existingBook.setTitle(book.getTitle());
        if (book.getPrice() != null) existingBook.setPrice(book.getPrice());

        Book updatedBook = bookRepository.save(existingBook);
        logger.info("Updated book: {}", id);
        return updatedBook;
    }

    @Override
    public void deleteBook(String id) {
        bookRepository.deleteById(id);
        logger.info("Deleted book: {}", id);
    }

    @Override
    public Book getBookById(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getBooksByCategoryId(String categoryId) {
        return bookRepository.findByCategoryId(categoryId);
    }
}
