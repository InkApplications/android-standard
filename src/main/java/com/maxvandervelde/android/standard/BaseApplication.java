package com.maxvandervelde.android.standard;

import android.app.Application;

import javax.inject.Inject;

import butterknife.ButterKnife;
import com.maxvandervelde.android.eventdispatcher.event.application.OnCreateEvent;
import com.maxvandervelde.android.eventdispatcher.event.application.OnLowMemoryEvent;
import com.maxvandervelde.android.eventdispatcher.event.application.OnTerminateEvent;
import com.maxvandervelde.android.standard.dependencyinjection.module.ApplicationModule;
import com.maxvandervelde.android.standard.dependencyinjection.registry.ApplicationRegistry;
import com.squareup.otto.Bus;
import dagger.ObjectGraph;

/**
 * Base Application
 *
 * @author Maxwell Vandervelde <Max@MaxVandervelde.com>
 */
public class BaseApplication extends Application
{
    @Inject Bus applicationBus;
    @Inject ApplicationRegistry registry;

    /**
     * Dagger Object Graph
     */
    private ObjectGraph objectGraph;

    @Override
    public void onCreate()
    {
        super.onCreate();

        ButterKnife.setDebug(BuildConfig.DEBUG);
        this.inject(this);
        this.registry.register();
        this.applicationBus.post(new OnCreateEvent(this));
    }

    @Override
    public void onTerminate()
    {
        super.onTerminate();
        this.applicationBus.post(new OnTerminateEvent(this));
    }

    @Override
    public void onLowMemory()
    {
        super.onLowMemory();
        this.applicationBus.post(new OnLowMemoryEvent(this));
    }

    /**
     * Inject
     *
     * Injects an object with dagger's Application activity graph
     *
     * @param object object that needs dependencies injected
     */
    public void inject(Object object)
    {
        this.getObjectGraph().inject(object);
    }

    /**
     * Get Object Graph
     *
     * @return The application object graph
     */
    final public ObjectGraph getObjectGraph()
    {
        if (null == this.objectGraph) {
            this.objectGraph = this.buildObjectGraph();
        }

        return this.objectGraph;
    }

    /**
     * Build Object Graph
     * 
     * @return A new dagger object graph
     */
    protected ObjectGraph buildObjectGraph()
    {
        ApplicationModule applicationModule = new ApplicationModule(this);

        ObjectGraph graph = ObjectGraph.create(applicationModule);

        return graph;
    }
}
