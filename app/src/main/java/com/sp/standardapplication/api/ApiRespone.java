package com.sp.standardapplication.api;


import retrofit2.Call;
import retrofit2.Response;


public abstract class ApiRespone<T> implements retrofit2.Callback<T> {

    public abstract void onApiSuccess(T t);

    public abstract void onApiError(String message);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            onApiSuccess(response.body());
        } else {
            onApiError("Something went wrong");
        }

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onApiError(t.getMessage());
    }
}
