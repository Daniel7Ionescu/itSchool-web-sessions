package com.dan.restone.practice.services;

import com.dan.restone.practice.models.entities.Book;

import java.util.List;

public interface BookService {


    List<Book> getAllBooks();
    Book createBook(Book book);
}
