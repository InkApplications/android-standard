package com.maxvandervelde.standard;

import android.app.Application;

import butterknife.ButterKnife;

import com.maxvandervelde.standard.BuildConfig;

import com.maxvandervelde.standard.dependencyinjection.modules.ApplicationModule;
import dagger.ObjectGraph;

/**
 * Base Application
 *
 * @author Maxwell Vandervelde <Max@MaxVandervelde.com>
 */
public class BaseApplication extends Application
{
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
    private ObjectGraph buildObjectGraph()
    {
        ApplicationModule applicationModule = new ApplicationModule(this);

        ObjectGraph graph = ObjectGraph.create(applicationModule);

        return graph;
    }
}
