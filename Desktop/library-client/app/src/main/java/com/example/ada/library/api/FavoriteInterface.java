package com.example.ada.library.api;


import com.example.ada.library.model.Favorite;

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

public interface FavoriteInterface {

    @GET("favorites/{userID}")
    Call<List<Favorite>> getAllUserFavorites(@Path("userID") Long userID);

    @POST("favorites/add")
    Call<Favorite> addBookToFavorites(@Body Favorite favorite);

    @POST("favorites/remove")
    Call<Favorite> removeBookFromFavorites(@Body Favorite favorite);

}
