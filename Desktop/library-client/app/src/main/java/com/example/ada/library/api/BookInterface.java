package com.example.ada.library.api;

import com.example.ada.library.model.Author;
import com.example.ada.library.model.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ada on 09.01.2019.
 */
public interface BookInterface {

    @GET("books")
    Call<List<Book>> getAllBooks();

    @GET("books/query/{query}")
    Call<List<Book>> getBookBySearach(@Path("query") String query);

    @GET("books/{id}")
    Call<Book> getBook(@Path("id") Long id);

    /*
    @GET("authors/{bookID}")
    Call<List<Author>> getAuthorsForBook(@Path("id") Long id);
    */
}
