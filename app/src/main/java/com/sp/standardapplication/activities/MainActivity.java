package com.sp.standardapplication.activities;

import android.os.Bundle;

import com.sp.standardapplication.R;
import com.sp.standardapplication.api.ApiClient;
import com.sp.standardapplication.api.ApiRespone;
import com.sp.standardapplication.base.BaseActivity;
import com.sp.standardapplication.helper.Utility;
import com.sp.standardapplication.model.UserResponse;

import retrofit2.Call;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_main);

        setToolBarTitle("Toolbar");


        if (Utility.isConnectingToInternet(this)) {
            showProgress();
            getUserDataApi();
        } else {
            showToast(getString(R.string.msg_no_internet));
        }

    }

    @Override
    protected void initializeData() {

    }

    @Override
    protected void setListeners() {

    }

    private void getUserDataApi() {

        Call<UserResponse> getResponseCall = ApiClient.getInstance(this).getApiResp().getUserData();
        getResponseCall.enqueue(new ApiRespone<UserResponse>() {
            @Override
            public void onApiSuccess(UserResponse userResponse) {
                hideProgress();
            }

            @Override
            public void onApiError(int errorcode) {
                hideProgress();
                showToast(errorcode);
            }
        });
    }


}
