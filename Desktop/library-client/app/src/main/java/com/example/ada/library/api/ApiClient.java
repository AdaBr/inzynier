package com.example.ada.library.api;

import com.example.ada.library.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ada on 16.01.2019.
 */

public class ApiClient {

    private static Retrofit retrofit = null;

    public ApiClient() {
        retrofit=null;
    }

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
