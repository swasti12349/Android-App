package com.sro.androidapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIendPoints {

    @GET("v1/public/characters")
    Call<List<marvel>> getMarvelChar(
            @Query("apikey") String key
    );

}
