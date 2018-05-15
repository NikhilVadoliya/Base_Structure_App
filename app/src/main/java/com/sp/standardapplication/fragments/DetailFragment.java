package com.sp.standardapplication.fragments;


/**
 * Copyright (c) 2015-2016 Sailfin Technologies, Pvt. Ltd.  All Rights Reserved.
 * This software is the confidential and proprietary information
 * (Confidential Information) of Sailfin Technologies, Pvt. Ltd.  You shall not
 * disclose or use Confidential Information without the express written
 * agreement of Sailfin Technologies, Pvt. Ltd.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sp.standardapplication.R;

/**
 * Created by nikhil.vadoliya on 15-05-2018.
 */


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
}
