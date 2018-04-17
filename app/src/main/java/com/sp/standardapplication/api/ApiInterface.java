package com.sp.standardapplication.api;


/**
 * Copyright (c) 2015-2016 Sailfin Technologies, Pvt. Ltd.  All Rights Reserved.
 * This software is the confidential and proprietary information
 * (Confidential Information) of Sailfin Technologies, Pvt. Ltd.  You shall not
 * disclose or use Confidential Information without the express written
 * agreement of Sailfin Technologies, Pvt. Ltd.
 */

import com.sp.standardapplication.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by nikhil.vadoliya on 05-04-2018.
 */


public interface ApiInterface {

    @GET("posts/1")
    Call<UserResponse> getUserData();

}
