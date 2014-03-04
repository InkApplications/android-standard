package com.maxvandervelde.android.standard.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import com.maxvandervelde.android.standard.BaseApplication;
import com.maxvandervelde.android.standard.activity.BaseActivity;
import com.maxvandervelde.android.standard.dependencyinjection.module.ActivityModule;
import com.maxvandervelde.android.standard.dependencyinjection.module.ApplicationModule;
import dagger.ObjectGraph;

public abstract class BaseFragment extends Fragment
{
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        ButterKnife.inject(this, view);
        this.injectDagger();
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    /**
     * Inject Dagger
     *
     * Uses Dagger to inject the current class
     */
    private void injectDagger()
    {
        BaseActivity parentActivity = (BaseActivity) this.getActivity();
        BaseApplication baseApplication = (BaseApplication) parentActivity.getApplication();

        ActivityModule activityModule = new ActivityModule(parentActivity);
        ApplicationModule applicationModule = new ApplicationModule(baseApplication);

        ObjectGraph graph = ObjectGraph.create(applicationModule, activityModule);

        graph.inject(this);
    }
}
