package com.example.ada.library.api;

import com.example.ada.library.model.BasketBook;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by ada on 22.01.2019.
 */

public interface BasketBookInterface {

    @GET("basketbooks/{basketID}")
    Call<List<BasketBook>> getBooksFromBasket(@Path("basketID") Long basketID);

    @GET("basketbooks/{userID}/{status}")
    Call<List<BasketBook>> getBooksFromUserBasketWithStatus(@Path("userID") Long userID,@Path("status") String status);

    @POST("basketbooks/add")
    Call<BasketBook> addBookToBasketBook(@Body BasketBook basketBook);

    @POST("basketbooks/remove")
    Call<BasketBook> removeBookFromBasketBook(@Body BasketBook basketBooke);
}
