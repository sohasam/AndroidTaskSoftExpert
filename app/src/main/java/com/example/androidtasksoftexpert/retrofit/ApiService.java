package com.example.androidtasksoftexpert.retrofit;

import com.example.androidtasksoftexpert.pojos.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("api/v1/cars")
    public Call<ResponseModel> getData(@Query("page") int currentPage);
}
