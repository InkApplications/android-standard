package com.maxvandervelde.android.standard.dependencyinjection.module;

import android.app.Application;

import javax.inject.Singleton;

import com.maxvandervelde.android.eventdispatcher.dependencyinjection.module.AndroidEventsModule;
import com.maxvandervelde.android.standard.BaseApplication;
import dagger.Module;
import dagger.Provides;

@Module(
    injects = {
        BaseApplication.class
    },
    includes = {
        AndroidEventsModule.class
    },
    staticInjections = { EeagerSingletons.class },
    complete = false,
    library = true
)
public class StandardApplicationModule
{
    final private BaseApplication application;

    public StandardApplicationModule(BaseApplication application)
    {
        this.application = application;
    }

    @Provides @Singleton Application provideApplication()
    {
        return this.application;
    }
}
