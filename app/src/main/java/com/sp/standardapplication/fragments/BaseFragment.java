package com.sp.standardapplication.fragments;


/**
 * Copyright (c) 2015-2016 Sailfin Technologies, Pvt. Ltd.  All Rights Reserved.
 * This software is the confidential and proprietary information
 * (Confidential Information) of Sailfin Technologies, Pvt. Ltd.  You shall not
 * disclose or use Confidential Information without the express written
 * agreement of Sailfin Technologies, Pvt. Ltd.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sp.standardapplication.base.BaseActivity;

/**
 * Created by nikhil.vadoliya on 06-04-2018.
 */


public abstract class BaseFragment extends Fragment {


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initializeData();
        setListeners();
        setToolbar();
    }

    protected abstract void initializeData();

    protected abstract void setListeners();

    protected abstract void setToolbar();

    public void setToolbar(String title, boolean isBack) {
        ((BaseActivity) getActivity()).setToolBarTitle(title, isBack);
    }

    public void showProgress() {
        ((BaseActivity) getActivity()).showProgress();
    }

    public void hideProgress() {
        ((BaseActivity) getActivity()).hideProgress();
    }

    public void showToast(String s) {
        ((BaseActivity) getActivity()).showToast(s);
    }

    public void showToast(int errorcode) {
        ((BaseActivity) getActivity()).showToast(errorcode);

    }
}
