package com.sro.androidapp.network;

import com.sro.androidapp.model.DataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface api {

    @GET("posts")
    Call<List<DataModel>> getAllItems();
}
