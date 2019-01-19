package com.example.ada.library.nieuzywane;

import com.example.ada.library.activity.BookDetailsActivity;
import com.example.ada.library.activity.BooksListAdapter;
import com.example.ada.library.model.Author;
import com.example.ada.library.model.Book;
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

public class BooksDetailsClientImp {

    BooksListAdapter booksListActivity;
    BookDetailsActivity bookDetailsActivity;

    /*
    public void getBooksList() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BookInterface bookClient = retrofit.create(BookInterface.class);
        Call<List<Book>> call = bookClient.getAllBooks();
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                booksListActivity.getAllBooks(response.body());

                /*
                if (!response.isSuccessful()) {
                    textView.setText("code: " + response.code());
                    return;
                }

                List<Book> books = response.body();

                for (Book book : books) {
                    String content = "";
                    content += "ID: " + book.getId() + "\n";
                    content += "ISBN: " + book.getISBN() + "\n";
                    content += "title: " + book.getTitle() + "\n\n";

                    textView.append(content);
                }
                */
/*
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {

            }
        });
    }


    public void getBooksList(String search) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BookInterface bookClient = retrofit.create(BookInterface.class);
        Call<List<Book>> call = bookClient.getBookBySearach(search);
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                booksListActivity.getBooksBySearch(response.body());
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {

            }
        });
    }

    public void getBook(Long id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BookInterface bookClient = retrofit.create(BookInterface.class);
        Call<Book> call = bookClient.getBook(id);
        call.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                bookDetailsActivity.getBook(response.body());
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {

            }
        });

    }

    /*
    public void getAuthorsForBook(Long bookID) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BookInterface bookClient = retrofit.create(BookInterface.class);
        Call<List<Author>> call = bookClient.getAuthorsForBook(bookID);
        call.enqueue(new Callback<List<Author>>() {
            @Override
            public void onResponse(Call<List<Author>> call, Response<List<Author>> response) {
                bookDetailsActivity.getAuthorsForBook(response.body());
            }

            @Override
            public void onFailure(Call<List<Author>> call, Throwable t) {

            }
        });
    }
    */



}
