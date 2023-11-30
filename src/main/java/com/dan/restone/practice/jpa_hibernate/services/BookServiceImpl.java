package com.dan.restone.practice.jpa_hibernate.services;

import com.dan.restone.practice.jpa_hibernate.models.entities.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class BookServiceImpl implements BookService{

    List<Book> bookList = new ArrayList<>();

    @Override
    public List<Book> getAllBooks() {
        log.info("Retrieved bookList");
        return bookList;
    }

    @Override
    public Book createBook(Book book) {
        if(!isValid(book)){
            throw new RuntimeException("Invalid input");
        }
        long bookId = bookList.size() + 1L;
        book.setId(bookId);

        //save the book
        bookList.add(book);
        log.info("Book with id: {} has been created.", bookId);

        return bookList.get((int) bookId - 1);
    }

    private boolean isValid(Book book) {
        if(book.getTitle().isEmpty() && book.getAuthor().isEmpty() || book.getPrice() == null){
            return false;
        }
        return true;
    }
}
