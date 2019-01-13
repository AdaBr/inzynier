package com.example.library.service;

import com.example.library.repository.BookRepository;
import com.example.library.commons.DataValidationException;
import com.example.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookCommandService {

    @Autowired
    private BookRepository bookRepository;

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void modifyBook(Book modifiedBook) {
        validateBookId(modifiedBook);
        Book bookFound = bookRepository.getOne(modifiedBook.getId());
        modifyPropertiesIfChanged(bookFound, modifiedBook);
    }

    public void removeBook(Book book) {
        validateBookId(book);
        bookRepository.delete(book);
    }

    public void removeAllBooks() {
        bookRepository.deleteAll();
    }

    private Book modifyPropertiesIfChanged(Book original, Book modified) {
        Book resultBook = original;
        if (original.getId() != modified.getId()) {
            throw new DataValidationException("You can't modify Book's ISBN number");
        }

        resultBook.setId(original.getId());
        if (modified.getTitle() != null &&  !(original.getTitle().equals(modified.getTitle()))) {
            resultBook.setTitle(modified.getTitle());
        } else {
            resultBook.setTitle(original.getTitle());
        }

        return resultBook;
    }

    private void validateBookId(Book book) {
        Book foundBook = bookRepository.getOne(book.getId());
        if (foundBook == null) {
            throw new DataValidationException("Invalid Book id. Doesn't exist in database");
        }
    }

}
