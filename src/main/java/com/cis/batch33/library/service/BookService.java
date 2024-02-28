package com.cis.batch33.library.service;

import com.cis.batch33.library.entity.LibraryBook;
import com.cis.batch33.library.repository.LibraryBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class BookService {

    @Autowired
    private LibraryBookRepository bookRepository;
    public LibraryBook createBook(LibraryBook book){
        // call the database
        Integer bookId = new Random().nextInt();
        book.setBookId(bookId);
        return  bookRepository.save(book);
    }

    public LibraryBook getBook(int bookId) {
        Optional<LibraryBook> bookOptional = bookRepository.findById(bookId);
        if (bookOptional.isPresent()) {
            return  bookOptional.orElse(new LibraryBook());
        } else {
            return null; // Member not found for the given memberId
        }
    }

    public LibraryBook updateBook(int bookId, LibraryBook updatedBook) {
        Optional<LibraryBook> bookOptional = bookRepository.findById(bookId);

        if (bookOptional.isPresent()) {
            LibraryBook existingBook = bookOptional.get();

            // Update the fields of existingMember with the values from updatedMember
            existingBook.setBookId(updatedBook.getBookId());
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthorName(updatedBook.getAuthorName());
            existingBook.setYearPublished(updatedBook.getYearPublished());
            existingBook.setQuantity(updatedBook.getQuantity());

            // Save the updated member and return the updated member
            return bookRepository.save(existingBook);
        } else {
            return null; // Member not found for the given memberId
        }
    }

    public void deleteBook(int bookId) {
        bookRepository.deleteById(bookId);
    }
}