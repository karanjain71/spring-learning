package com.springboot.restapis2.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springboot.restapis2.entities.Book;

public interface BookRepository extends CrudRepository<Book,Integer> {
    
}
