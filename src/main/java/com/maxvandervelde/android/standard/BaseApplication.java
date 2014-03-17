package com.maxvandervelde.android.standard;

import android.app.Application;

import javax.inject.Inject;

import com.maxvandervelde.android.eventdispatcher.event.application.OnCreateEvent;
import com.maxvandervelde.android.eventdispatcher.event.application.OnLowMemoryEvent;
import com.maxvandervelde.android.eventdispatcher.event.application.OnTerminateEvent;
import com.maxvandervelde.android.standard.dependencyinjection.module.StandardApplicationModule;
import com.squareup.otto.Bus;
import dagger.ObjectGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Base Application
 *
 * @author Maxwell Vandervelde <Max@MaxVandervelde.com>
 */
public class BaseApplication extends Application
{
    @Inject Bus applicationBus;

    /**
     * Dagger Object Graph
     */
    private ObjectGraph objectGraph;

    @Override
    public void onCreate()
    {
        super.onCreate();

        this.inject(this);
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
        ObjectGraph graph = ObjectGraph.create(this.getModules().toArray());

        return graph;
    }

    public List<Object> getModules()
    {
        StandardApplicationModule applicationModule = new StandardApplicationModule(this);

        ArrayList<Object> modules = new ArrayList<Object>();
        modules.add(applicationModule);

        return modules;
    }
}
