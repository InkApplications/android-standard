package com.maxvandervelde.standard.dependencyinjection.modules;

import javax.inject.Singleton;

import android.app.Application;

import com.maxvandervelde.standard.BaseApplication;

import dagger.Module;
import dagger.Provides;

@Module(
    injects = {
        BaseApplication.class
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

    @Provides @Singleton
    public Application provideApplication()
    {
        return this.application;
    }
}
