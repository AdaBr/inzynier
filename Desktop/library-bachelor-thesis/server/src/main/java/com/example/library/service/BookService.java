package com.example.library.service;


import com.example.library.commons.BookNotFoundExcpetion;
import com.example.library.model.Author;
import com.example.library.model.AuthorBook;
import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private AuthorBookService authorBookService;


    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBook(Book book) {
        return bookRepository.findById(book.getId()).orElseThrow(()-> new BookNotFoundExcpetion(book.getId()));
    }

    public Book getBook(Long id) {
        try {
            return bookRepository.findById(id).orElseThrow(()-> new BookNotFoundExcpetion(id));
        }
        catch (BookNotFoundExcpetion e) {
            return new Book();
        }
    }


    public List<Book> getBookBySearch(String searach) {

        Set<Book> result = new HashSet<Book>();

        List<Book> resultAuthors = getBookByAuthor(searach);
        List<Book> resultTitle = getBookByTitle(searach);
        List<Book> resultISBN = getBookByISBN(searach);

        if (!resultAuthors.isEmpty()) {
            result.addAll(resultAuthors);
        }

        if (!resultTitle.isEmpty()) {
            result.addAll(resultTitle);
        }

        if (!resultISBN.isEmpty()) {
            result.addAll(resultISBN);
        }

        List <Book> resultList= new ArrayList<>();
        resultList.addAll(result);

        return resultList;
    }


    public List<Book> getBookByTitle(String title) {

        List<Book> result = new ArrayList<Book>();
        for(Book book : bookRepository.findAll()) {
            if(book.getTitle().toLowerCase().contains(title.toLowerCase()) ||
                    title.toLowerCase().contains(book.getTitle().toLowerCase())) {
                result.add(getBook(book.getId()));
            }
        }
        return result;
    }

    public List<Book> getBookByISBN(String ISBN) {

        List<Book> result = new ArrayList<Book>();
        for (Book book : bookRepository.findAll()) {
            if (book.getISBN().toLowerCase().contains(ISBN.toLowerCase()) ||
                    ISBN.toLowerCase().contains(book.getISBN().toLowerCase())) {
                result.add(getBook(book.getId()));
            }
        }
        return result;
    }

    public List<Book> getBookByAuthor(String author) {
        List<Long> authorsID = authorService.getAuthorsIDSearchByName(author);
        List<Long> booksID = new ArrayList<>();

        for (Long authorID : authorsID){
            for (AuthorBook authorBook : authorBookService.getBooksIDWithAuthorsID(authorID)) {
                booksID.add(authorBook.getAuthorBookIdentity().getBookID());
            }
        }

        return bookRepository.findAllById(booksID);

    }

    public String getBookTitle(Long id) {
        Book book = getBook(id);
        return book.getTitle();
    }

    public String getBookCover(Long bookID) {
        Book book = getBook(bookID);
        return book.getAddressURLOfPhoto();
    }

    public Float getBookPrice(Long bookID) {
        Book book = getBook(bookID);
        return book.getPrice();
    }


    /*
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
        if (modified.getBookTitle() != null &&  !(original.getBookTitle().equals(modified.getBookTitle()))) {
            resultBook.setBookTitle(modified.getBookTitle());
        } else {
            resultBook.setBookTitle(original.getBookTitle());
        }

        return resultBook;
    }

    private void validateBookId(Book book) {
        Book foundBook = bookRepository.getOne(book.getId());
        if (foundBook == null) {
            throw new DataValidationException("Invalid Book id. Doesn't exist in database");
        }
    }

     */

}
