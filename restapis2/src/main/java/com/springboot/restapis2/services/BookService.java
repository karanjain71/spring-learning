package com.springboot.restapis2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.restapis2.entities.Book;
import com.springboot.restapis2.repositories.BookRepository;

@Component
public class BookService {
    // private static List<Book> books = new ArrayList<>();
    // static{
    //     books.add(new Book("12","Karan Jain biography","Pratik Sahu"));
    //     books.add(new Book("13","Deepak Jain biography","Pratik Washington"));
    //     books.add(new Book("14","Sonu Jain biography","Pratik Thakur"));
    // }
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return (List<Book>)bookRepository.findAll();
    }
    public Book getBookById(int id){
        Optional<Book> requiredBook = bookRepository.findById(id);
        return requiredBook.get();
    }
    public Book addBook(Book book){
        Book bookResponse = bookRepository.save(book);
        return bookResponse;
    }

    public void deleteBookById(int id){
        bookRepository.deleteById(id);
    }

    public Book updateBookById(Book b){

        Optional<Book> op = bookRepository.findById(b.getId());
        Book book = op.get();
        book.setTitle(b.getTitle());
        book.setAuthor(b.getAuthor());
        Book bookResponse = bookRepository.save(book);
        return bookResponse;
    }
}
