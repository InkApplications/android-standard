package com.maxvandervelde.standard.fragment;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;

import com.maxvandervelde.standard.BaseApplication;

public abstract class BaseFragment extends Fragment
{
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        Activity parentActivity = this.getActivity();
        Application application = parentActivity.getApplication();

        if (application instanceof BaseApplication) {
            BaseApplication baseApp = (BaseApplication) application;
            baseApp.inject(this);
        }

        ButterKnife.inject(this, view);
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
