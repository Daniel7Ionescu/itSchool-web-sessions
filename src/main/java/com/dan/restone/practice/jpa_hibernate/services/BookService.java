package com.dan.restone.practice.jpa_hibernate.services;

import com.dan.restone.practice.jpa_hibernate.models.entities.Book;

import java.util.List;

public interface BookService {


    List<Book> getAllBooks();
    Book createBook(Book book);
}
