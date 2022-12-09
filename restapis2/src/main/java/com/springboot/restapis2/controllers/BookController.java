package com.springboot.restapis2.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.restapis2.entities.Book;
import com.springboot.restapis2.services.BookService;

@RestController
public class BookController {
    
    @Autowired
    private BookService bookService;

    @ResponseStatus
    @GetMapping(value="/books")
    public ResponseEntity<List<Book>> getBooks(){
        try {
            List<Book> books = bookService.getAllBooks();
            if(books.size()<=0){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            else{
                return ResponseEntity.of(Optional.of(books));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatusCode.valueOf(500)).build();
        }
    }

    @GetMapping(value="/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id){
        System.out.println(id+"This is the id");
        try {
            Book b = bookService.getBookById(id);
            return ResponseEntity.of(Optional.of(b));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatusCode.valueOf(500)).build();
        }
    }

    @PostMapping(value="/books")
    public Book addBook(@RequestBody Book book){
        Book b = bookService.addBook(book);
        return b;
    }

    @DeleteMapping(value="/books/{id}")
    public ResponseEntity<String> deleteBooks(@PathVariable("id") Integer id){
        try {
            bookService.deleteBookById(id);
            return ResponseEntity.status(HttpStatusCode.valueOf(204)).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping(value="/books/{id}")
    public ResponseEntity<Void> updateBooks(@PathVariable("id") int id, @RequestBody Book book){
        try {
            bookService.updateBookById(book);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build(); 
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
