package com.example.library.book;

import com.example.library.author.AuthorSearchService;
import com.example.library.authorbook.AuthorBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BookSearchService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorSearchService authorSearchService;

    @Autowired
    private AuthorBookService authorBookService;


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
        for(Book book : this.bookRepository.findAll()) {
            if(book.getTitle().toLowerCase().contains(title.toLowerCase()) ||
                    title.toLowerCase().contains(book.getTitle().toLowerCase())) {
                result.add(this.bookRepository.findById(book.getId()).orElseThrow(() -> new BookNotFoundExcpetion(title)));
            }
        }
        return result;
    }

    public List<Book> getBookByISBN(String ISBN) {

        List<Book> result = new ArrayList<Book>();
        for (Book book : bookRepository.findAll()) {
            if (book.getISBN().toLowerCase().contains(ISBN.toLowerCase()) ||
                ISBN.toLowerCase().contains(book.getISBN().toLowerCase())) {
                result.add(this.bookRepository.findById(book.getId()).orElseThrow(() -> new BookNotFoundExcpetion(ISBN)));
            }
        }
        return result;
    }

    public List<Book> getBookByAuthor(String author) {
        List<Long> authorsID = authorSearchService.getAuthorsIDSearchByName(author);

        List<Long> booksID = this.authorBookService.getBooksIDWithAuthorsID(authorsID);

        return this.bookRepository.findAllById(booksID);

    }

}


