package com.sp.standardapplication.api;



import com.sp.standardapplication.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {

    @GET("posts/1")
    Call<UserResponse> getUserData();

}
