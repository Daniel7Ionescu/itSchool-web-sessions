package com.dan.restone.services;

import com.dan.restone.models.entities.Book;

import java.util.List;

public interface BookService {


    List<Book> getAllBooks();
    Book createBook(Book book);
}
