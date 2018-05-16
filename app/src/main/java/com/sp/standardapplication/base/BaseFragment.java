package com.sp.standardapplication.base;




import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



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
        showData();
    }

    protected abstract void initializeData();

    protected abstract void setListeners();

    protected abstract void setToolbar();

    protected abstract void showData();

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
