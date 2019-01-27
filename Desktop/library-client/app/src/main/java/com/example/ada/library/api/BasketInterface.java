package com.example.ada.library.api;

import com.example.ada.library.model.Basket;
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

public interface BasketInterface {

    @GET("baskets/{userID}")
    Call<List<Basket>> getBasketForUser(@Path("basketD") Long userID);


    @GET("baskets/{userID}/{status}")
    Call<List<Basket>> getBasketWithStatusForUser(@Path("userID") Long userID, @Path("status") String status);

    @POST("baskets/modify")
    Call<Basket> modifyBasket(@Body Basket basket);


}
