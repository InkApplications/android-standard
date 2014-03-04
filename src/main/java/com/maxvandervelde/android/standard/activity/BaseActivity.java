package com.maxvandervelde.android.standard.activity;

import android.app.Activity;
import android.os.Bundle;

import javax.inject.Inject;

import butterknife.ButterKnife;
import com.maxvandervelde.android.eventdispatcher.event.activity.*;
import com.maxvandervelde.android.standard.BaseApplication;
import com.maxvandervelde.android.standard.dependencyinjection.module.ActivityModule;
import com.maxvandervelde.android.standard.dependencyinjection.module.ApplicationModule;
import com.maxvandervelde.android.standard.dependencyinjection.registry.ActivityRegistry;
import com.squareup.otto.Bus;
import dagger.ObjectGraph;

/**
 * Base Activity
 *
 * Sets up an Activity with Dependency Injection and registers Activity events
 * with the application event dispatcher / bus.
 *
 * @author Maxwell Vandervelde <Max@MaxVandervelde.com>
 */
public abstract class BaseActivity extends Activity
{
    @Inject Bus applicationBus;
    @Inject ActivityRegistry registry;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.injectSelf();
        this.registry.register();
        this.applicationBus.post(new OnCreateEvent(this, savedInstanceState));
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        this.applicationBus.post(new OnStartEvent(this));
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        this.applicationBus.post(new OnResumeEvent(this));
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        this.applicationBus.post(new OnPauseEvent(this));
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        this.applicationBus.post(new OnStartEvent(this));
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        this.applicationBus.post(new OnRestartEvent(this));
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        this.applicationBus.post(new OnDestroyEvent(this));
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

    /**
     * Inject Dagger
     *
     * Uses Dagger to inject the current class
     */
    private void injectDagger()
    {
        ActivityModule activityModule = new ActivityModule(this);

        BaseApplication baseApplication = (BaseApplication) this.getApplication();
        ApplicationModule applicationModule = new ApplicationModule(baseApplication);

        ObjectGraph graph = ObjectGraph.create(applicationModule, activityModule);

        graph.inject(this);
    }
}
