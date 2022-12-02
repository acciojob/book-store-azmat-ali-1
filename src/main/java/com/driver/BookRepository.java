package com.driver;
import java.util.*;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public class BookRepository {


    public BookRepository(){
        
    }

    Map<Integer,Book> bookMap = new HashMap<>();

    public Book save(Book book){
        int number = bookMap.size()+1;
        book.setId(number);
        bookMap.put(number,book);
        return book;
    }

    public Book findBookById(int id){
        return bookMap.get(id);
    }

    public List<Book> findAll(){
        List<Book> book = new ArrayList<>();
        for(Integer i : bookMap.keySet()){
            book.add(bookMap.get(i));
        }
        return book;
    }

    public void deleteBookById(int id){
        bookMap.remove(id);
    }

    public void deleteAll(){
        bookMap.clear();
    }

    public List<Book> findBooks_ByAuthor(String author){
        List<Book> listOfBook = new ArrayList<>();
        for(Book book : bookMap.values()){
            if(Objects.equals(author,book.getAuthor())){
                listOfBook.add(book);
            }
        }

        return listOfBook;
    }

    public List<Book> findBooks_ByGenre(String genre){
        List<Book> listOfBook = new ArrayList<>();
        for(Book book : bookMap.values()){
            if(Objects.equals(genre,book.getGenre())){
                listOfBook.add(book);
            }
        }

        return listOfBook;
    }
}
