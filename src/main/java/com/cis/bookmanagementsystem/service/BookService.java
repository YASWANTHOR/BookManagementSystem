package com.cis.bookmanagementsystem.service;

import com.cis.bookmanagementsystem.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class BookService {
    private final Map<Integer, Book> integerBookMap = new HashMap<>();
    public Book createBook(Book book) {
        book.setBookId(Math.abs(new Random().nextInt()));
        integerBookMap.put(book.getBookId(), book);
        return book;
    }

    public Book readBook(int bookId) {
        System.out.println(integerBookMap.get(bookId).getBookName());
        return integerBookMap.get(bookId);
    }



    public Book updateBookData(int bookId, Book updatedBook) {
        System.out.println(integerBookMap);
        if(integerBookMap.containsKey(bookId)) {
            Book book = integerBookMap.get(bookId);
            if(!book.getBookName().isEmpty()) {
                book.setBookName(updatedBook.getBookName());
            }
            if(!book.getBookName().isEmpty()) {
                book.setBookName(updatedBook.getBookName());
            }
            if(!book.getAuthor().isEmpty()) {
                book.setAuthor(updatedBook.getAuthor());
            }
            if(!book.getEdition().isEmpty()) {
                book.setEdition(updatedBook.getEdition());
            }
            integerBookMap.put(bookId, book);
            System.out.println("updated successfully");
            return book;
        }
        return null;
    }

    public Book deleteBook(int bookId) {
        return integerBookMap.remove(bookId);
    }
}
