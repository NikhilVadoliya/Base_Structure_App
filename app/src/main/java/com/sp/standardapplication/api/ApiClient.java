package com.sp.standardapplication.api;


/**
 * Copyright (c) 2015-2016 Sailfin Technologies, Pvt. Ltd.  All Rights Reserved.
 * This software is the confidential and proprietary information
 * (Confidential Information) of Sailfin Technologies, Pvt. Ltd.  You shall not
 * disclose or use Confidential Information without the express written
 * agreement of Sailfin Technologies, Pvt. Ltd.
 */

import android.content.Context;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.sp.standardapplication.helper.Constants.BASE_URL;

/**
 * Created by nikhil.vadoliya on 05-04-2018.
 */


public class ApiClient {

    public static Retrofit retrofit = null;
    private static ApiClient apiClient;
    public ApiInterface apiInterface;

    private ApiClient() {

    }


    public static ApiClient getInstance() {
        if (apiClient == null)
            apiClient = new ApiClient();
        return apiClient;
    }

    public ApiInterface getApiResp() {
        try {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

            httpClient.addInterceptor(logging);
            OkHttpClient client = httpClient.build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
            apiInterface = retrofit.create(ApiInterface.class);
            return apiInterface;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
