package com.maxvandervelde.standard.activity;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;

import com.maxvandervelde.standard.dependencyinjection.modules.ActivityModule;
import com.maxvandervelde.standard.dependencyinjection.modules.ApplicationModule;

import dagger.ObjectGraph;

import com.maxvandervelde.standard.BaseApplication;

/**
 * Base Activity
 *
 * @author Maxwell Vandervelde <Max@MaxVandervelde.com>
 */
public abstract class BaseActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        this.injectSelf();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
    }

    /**
     * Inject Self
     *
     * Injects the current activity using both butterknife inject and dagger
     */
    private void injectSelf()
    {
        ButterKnife.inject(this);
        this.injectDagger();
    }

    private void injectDagger()
    {
        ActivityModule activityModule = new ActivityModule(this);

        BaseApplication baseApplication = (BaseApplication) this.getApplication();
        ApplicationModule applicationModule = new ApplicationModule(baseApplication);

        ObjectGraph graph = ObjectGraph.create(applicationModule, activityModule);

        graph.inject(this);
    }
}
