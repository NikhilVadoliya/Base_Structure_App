package com.sp.standardapplication.api;


/**
 * Copyright (c) 2015-2016 Sailfin Technologies, Pvt. Ltd.  All Rights Reserved.
 * This software is the confidential and proprietary information
 * (Confidential Information) of Sailfin Technologies, Pvt. Ltd.  You shall not
 * disclose or use Confidential Information without the express written
 * agreement of Sailfin Technologies, Pvt. Ltd.
 */


import com.sp.standardapplication.helper.Constants;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by nikhil.vadoliya on 05-04-2018.
 */


public abstract class ApiRespone<T> implements retrofit2.Callback<T> {

    public abstract void onApiSuccess(T t);

    public abstract void onApiError(int errorcode);

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            onApiSuccess(response.body());
        } else {
            onApiError(Constants.API_ERROR_CODE_3);
        }

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if (t instanceof SocketTimeoutException) {
            onApiError(Constants.API_ERROR_CODE_1);
        } else if (t instanceof UnknownHostException) {
            onApiError(Constants.API_ERROR_CODE_2);
        } else {
            onApiError(Constants.API_ERROR_CODE_3);
        }

    }
}
