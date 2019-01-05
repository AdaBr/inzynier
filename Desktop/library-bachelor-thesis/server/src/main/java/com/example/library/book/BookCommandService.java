package com.example.library.book;

import com.example.library.commons.DataValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class BookCommandService {

    @Autowired
    private BookRepository bookRepository;

    void addBook(Book book) {
        Book foundBook = bookRepository.getOne(book.getISBN());
        if (foundBook == null) {
            throw new DataValidationException("You can't add Book without ISBN number.");
        }
        bookRepository.save(book);
    }

    void modifyBook(Book modifiedBook) {
        validateBookISBN(modifiedBook);
        Book bookFound = bookRepository.getOne(modifiedBook.getISBN());
        modifyPropertiesIfChanged(bookFound, modifiedBook);
    }

    void removeBook(Book book) {
        validateBookISBN(book);
        bookRepository.delete(book);
    }

    void removeAllBooks() {
        bookRepository.deleteAll();
    }

    private Book modifyPropertiesIfChanged(Book original, Book modified) {
        Book resultBook = original;
        if (original.getISBN() != modified.getISBN()) {
            throw new DataValidationException("You can't modify Book's ISBN number");
        }

        resultBook.setISBN(original.getISBN());
        if (modified.getTitle() != null &&  !(original.getTitle().equals(modified.getTitle()))) {
            resultBook.setTitle(modified.getTitle());
        } else {
            resultBook.setTitle(original.getTitle());
        }

        return resultBook;
    }

    private void validateBookISBN(Book book) {
        Book foundBook = bookRepository.getOne(book.getISBN());
        if (foundBook == null) {
            throw new DataValidationException("Invalid Book id. Doesn't exist in database");
        }
    }

}
