package com.sp.standardapplication.activities;

import android.os.Bundle;

import com.sp.standardapplication.R;
import com.sp.standardapplication.api.ApiClient;
import com.sp.standardapplication.api.ApiRespone;
import com.sp.standardapplication.base.BaseActivity;
import com.sp.standardapplication.fragments.ListDataFragment;
import com.sp.standardapplication.model.UserResponse;

import retrofit2.Call;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_main);



       /* if (Utility.isConnectingToInternet(this)) {
            showProgress();
            getUserDataApi();
        } else {
            showToast(getString(R.string.msg_no_internet));
        }*/

        pushFragment(R.id.container, new ListDataFragment(), false);
    }

    @Override
    protected void initializeData() {

    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void showData() {

    }

    private void getUserDataApi() {

        Call<UserResponse> getResponseCall = ApiClient.getInstance().getApiResp().getUserData();
        getResponseCall.enqueue(new ApiRespone<UserResponse>() {
            @Override
            public void onApiSuccess(UserResponse userResponse) {
                //api response
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
