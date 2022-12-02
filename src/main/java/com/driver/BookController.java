package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/books/create-book")
    public ResponseEntity<Book> createBook(@RequestBody() Book book){
        Book newbook = bookService.create_Book(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }

    @GetMapping("/books/get-book-by-id/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id")String id){
        return new ResponseEntity<>(bookService.findBookById(id),HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/books/delete-book-by-id/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable("id") String id){
        bookService.delete_BookById(id);
        return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
    }
    @GetMapping("/books/get-all-books")
    public ResponseEntity<List<Book>> getAllBooks(){
        return new ResponseEntity<>(bookService.find_AllBooks(),HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/books/delete-all-books")
    public ResponseEntity<String> deleteAllBooks(){
        bookService.delete_AllBooks();
        return new ResponseEntity<>("success",HttpStatus.ACCEPTED);
    }
    @GetMapping("/books/get-books-by-author")
    public ResponseEntity<List<Book>> findBooksByAuthor(@RequestParam("author") String author){
        return new ResponseEntity<>(bookService.findBooksByAuthor(author),HttpStatus.ACCEPTED);
    }
    @GetMapping("/books/get-books-by-genre")
    public ResponseEntity<List<Book>> findBooksByGenre(@RequestParam("genre") String genre){
        return new ResponseEntity<>(bookService.find_BooksByGenre(genre),HttpStatus.ACCEPTED);
    }
}
