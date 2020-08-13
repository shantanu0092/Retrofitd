package com.shantanu.retrofitapp2.network;

import com.shantanu.retrofitapp2.Module.RetroPhoto;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/app-api/apiGetCategoryList")
    Call<RetroPhoto> getAllPhotos();
}
