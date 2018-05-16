package com.sp.standardapplication.base;


import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sp.standardapplication.R;
import com.sp.standardapplication.views.CustomProgressDialog;


public abstract class BaseActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView mToolbarTitle;
    ImageView mImgBack;
    String message;

    private CustomProgressDialog mProgressDialog;

    protected void onCreate(@Nullable Bundle savedInstanceState, int layout) {
        super.onCreate(savedInstanceState);
        setContentView(layout);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        toolbar = findViewById(R.id.toolbar);
        mToolbarTitle = findViewById(R.id.toolbar_title);
        mImgBack = findViewById(R.id.img_back);
        setSupportActionBar(toolbar);
        // Remove default title text
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //set statusbar color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }

        mProgressDialog = new CustomProgressDialog(this);
        initializeData();
        setListeners();
        showData();

        mImgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void setToolBarTitle(String title, boolean isBackButton) {
        mToolbarTitle.setText(title);
        mImgBack.setVisibility(isBackButton ? View.VISIBLE : View.GONE);

    }

    public void showToast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    public void showToast(int errorcode) {

        switch (errorcode) {
            case 1:
                message = getString(R.string.msg_api_error_timeout);
                break;
            case 2:
                message = getString(R.string.msg_api_error_unknown_host);
                break;

            default:
                message = getString(R.string.msg_api_error_something_want_wrong);

        }
        showToast(message);
    }

    public void showProgress() {
        try {
            if (mProgressDialog != null) {
                if (mProgressDialog.isShowing())
                    hideProgress();
                mProgressDialog.show("");
            }
        } catch (Exception e) {
            Log.e("show progress - ", e.getMessage());
        }
    }

    public void hideProgress() {
        try {
            if (mProgressDialog != null) {
                mProgressDialog.dismiss("");
                mProgressDialog.dismiss();
                mProgressDialog.hide("");
                mProgressDialog.hide();
            }
        } catch (Exception e) {
            Log.e("hide progress - ", e.getMessage());
        }
    }

    protected abstract void initializeData();

    protected abstract void setListeners();

    protected abstract void showData();

    public void pushFragment(int containerId, Fragment fragment, boolean addToStack) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if (addToStack) {
            ft.addToBackStack(null);
        }
        if (getSupportFragmentManager().findFragmentById(containerId) != null) {
            ft.hide(getSupportFragmentManager().findFragmentById(containerId));
        }
        ft.add(containerId, fragment);

        if (!isFinishing()) {
            ft.commitAllowingStateLoss();
        } else {
            ft.commit();
        }
    }

}
