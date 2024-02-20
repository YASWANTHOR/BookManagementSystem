package com.cis.bookmanagementsystem.controller;

import com.cis.bookmanagementsystem.pojo.Book;
import com.cis.bookmanagementsystem.pojo.Member;
import com.cis.bookmanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/bookcreate")
    public Book createdBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @GetMapping("/bookread")
    public String getBookById(@RequestParam int bookId) {
        System.out.println(bookService.readBook(bookId));
        return bookService.readBook(bookId).getBookName();
    }


    @PutMapping("/bookupdate")
    public Book update(@RequestParam int bookId,
                         @RequestBody Book book) {
        return bookService.updateBookData(bookId, book);
    }

    @DeleteMapping("/bookdelete")
    public Book delete(@RequestParam int bookId) {
        System.out.println("Book Deleted");
        return bookService.deleteBook(bookId);
    }
}
