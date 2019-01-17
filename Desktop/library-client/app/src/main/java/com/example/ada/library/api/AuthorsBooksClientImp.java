package com.example.ada.library.api;

import com.example.ada.library.activity.BooksListAdapter;
import com.example.ada.library.model.Author;
import com.example.ada.library.model.AuthorBook;
import com.example.ada.library.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ada on 10.01.2019.
 */

public class AuthorsBooksClientImp {

    BooksListAdapter booksListAdapter;

    /*
    public void getAuthorsList() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AuthorsBooksClient authorbookClient = retrofit.create(AuthorsBooksClient.class);
        Call<List<Author>> call = authorbookClient.getAllAuthors();
        call.enqueue(new Callback<List<Author>>() {
            @Override
            public void onResponse(Call<List<Author>> call, Response<List<Author>> response) {
                booksListAdapter.getAllAuthors(response.body());
            }

            @Override
            public void onFailure(Call<List<Author>> call, Throwable t) {

            }
        });
    }

    public void getAuthorsBooksList() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AuthorsBooksClient authorbookClient = retrofit.create(AuthorsBooksClient.class);
        Call<List<AuthorBook>> call = authorbookClient.getAllAuthorsBooks();
        call.enqueue(new Callback<List<AuthorBook>>() {
            @Override
            public void onResponse(Call<List<AuthorBook>> call, Response<List<AuthorBook>> response) {
                booksListAdapter.getAllAuthorsBooks(response.body());
            }

            @Override
            public void onFailure(Call<List<AuthorBook>> call, Throwable t) {

            }
        });
    }
    */
}
