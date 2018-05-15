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
import android.widget.Button;

import com.sp.standardapplication.R;
import com.sp.standardapplication.base.BaseActivity;

/**
 * Created by nikhil.vadoliya on 15-05-2018.
 */


public class ListDataFragment extends BaseFragment {

    View mView;
    Button mBtnDetail;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_list, container, false);
        return mView;
    }


    @Override
    protected void initializeData() {
        mBtnDetail = mView.findViewById(R.id.btn_detail);

    }

    @Override
    protected void setListeners() {
        mBtnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((BaseActivity) getActivity()).pushFragment(R.id.container, new DetailFragment(), true);
            }
        });

    }

    @Override
    protected void setToolbar() {
        setToolbar("FragmentToolbar", false);
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            setToolbar();
        }
    }
}
