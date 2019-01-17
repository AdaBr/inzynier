package com.example.ada.library.api;

import com.example.ada.library.model.Author;
import com.example.ada.library.model.AuthorBook;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ada on 10.01.2019.
 */

public interface AuthorsBooksClient {

    @GET("authors")
    Call<List<Author>> getAllAuthors();

    @GET("authorsbooks")
    Call<List<AuthorBook>> getAllAuthorsBooks();
}
