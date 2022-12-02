package com.driver;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class BookService {
    
    @Autowired
    BookRepository bookRepository;

    public Book create_Book(Book book){
        return bookRepository.save(book);
    }

    public Book findBookById(String id){
        return bookRepository.findBookById(Integer.parseInt(id));
    }

    public void delete_BookById(String id){
        bookRepository.deleteBookById(Integer.parseInt(id));
    }

    public List<Book> find_AllBooks(){
        return bookRepository.findAll();
    }

    public void delete_AllBooks(){
        bookRepository.deleteAll();
    }

    public List<Book> findBooksByAuthor(String author){
        return bookRepository.findBooks_ByAuthor(author);
    }

    public List<Book> find_BooksByGenre(String genre){
        return bookRepository.findBooks_ByGenre(genre);
    }
}
