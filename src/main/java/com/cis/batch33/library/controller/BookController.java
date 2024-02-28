package com.cis.batch33.library.controller;

import com.cis.batch33.library.entity.LibraryBook;
import com.cis.batch33.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/{bookId}")
    public LibraryBook getBook(@PathVariable int bookId){
        return bookService.getBook(bookId);
    }

    // create a book
    @PostMapping
    public LibraryBook createBook(@RequestBody LibraryBook book){
        return bookService.createBook(book);
    }

    @PutMapping("/{bookId}")
    public LibraryBook updateBook(@PathVariable int bookId, @RequestBody LibraryBook updatedBook){
        // Set the memberId for the member object to be updated
        return bookService.updateBook(bookId, updatedBook);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable int bookId){
        bookService.deleteBook(bookId);
    }
}