package com.maxvandervelde.android.standard.dependencyinjection.module;

import android.app.Application;

import javax.inject.Singleton;

import com.maxvandervelde.android.eventdispatcher.dependencyinjection.module.AndroidEventsModule;
import com.maxvandervelde.android.logger.ConsoleLogger;
import com.maxvandervelde.android.standard.BaseApplication;
import com.maxvandervelde.android.standard.BuildConfig;
import com.maxvandervelde.android.standard.dependencyinjection.registry.ApplicationRegistry;
import dagger.Module;
import dagger.Provides;
import org.apache.commons.logging.Log;

@Module(
    injects = {
        ApplicationRegistry.class,
        BaseApplication.class
    },
    includes = {
        AndroidEventsModule.class
    },
    complete = false,
    library = true
)
public class ApplicationModule
{
    final private BaseApplication application;

    public ApplicationModule(BaseApplication application)
    {
        this.application = application;
    }

    @Provides @Singleton Application provideApplication()
    {
        return this.application;
    }

    @Provides @Singleton Log provideLogger()
    {
        ConsoleLogger logger = new ConsoleLogger(BuildConfig.DEBUG, "Application");

        return logger;
    }
}
