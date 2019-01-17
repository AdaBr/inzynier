package com.example.ada.library.api;

import com.example.ada.library.model.Book;
import com.example.ada.library.model.UserBook;
import com.squareup.okhttp.RequestBody;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by ada on 17.01.2019.
 */

public interface UserBookInterface {

    @GET("userbooks/{userID}")
    Call<List<UserBook>> getAllUserBooks(@Path("userID") Long userID);

    @GET("userbooks/{userID}/status/{chosenStatus}")
    Call<List<UserBook>> getUserBooksWithStatus(@Path("userID") Long userID, @Path("chosenStatus") String chosenStatus);

    @POST("userbooks/add")
    Call<UserBook> addBookForUser(@Body UserBook userBook);

}
