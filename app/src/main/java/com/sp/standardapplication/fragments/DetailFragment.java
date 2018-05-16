package com.sp.standardapplication.fragments;




import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sp.standardapplication.R;
import com.sp.standardapplication.base.BaseFragment;



public class DetailFragment extends BaseFragment {

    View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_detail, container, false);
        return mView;
    }

    @Override
    protected void initializeData() {

    }

    @Override
    protected void setListeners() {

    }

    @Override
    protected void setToolbar() {
        setToolbar("DetailFragment", true);
    }

    @Override
    protected void showData() {

    }
}
