package com.inkapplications.android.standard.activity;

import android.app.Activity;
import android.os.Bundle;

import javax.inject.Inject;

import butterknife.ButterKnife;
import com.inkapplications.android.eventdispatcher.event.activity.*;
import com.inkapplications.android.standard.BaseApplication;
import com.inkapplications.android.standard.dependencyinjection.module.StandardActivityModule;
import com.inkapplications.android.standard.dependencyinjection.module.StandardApplicationModule;
import com.squareup.otto.Bus;
import dagger.ObjectGraph;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.injectSelf();
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
        ObjectGraph graph = ObjectGraph.create(this.getModules().toArray());

        graph.inject(this);
    }

    public List<Object> getModules()
    {
        StandardActivityModule activityModule = new StandardActivityModule(this);
        BaseApplication baseApplication = (BaseApplication) this.getApplication();
        StandardApplicationModule applicationModule = new StandardApplicationModule(baseApplication);

        ArrayList<Object> modules = new ArrayList<Object>();
        modules.add(applicationModule);
        modules.add(activityModule);

        return modules;
    }
}
