package com.maxvandervelde.android.standard.dependencyinjection.module;

import android.app.Activity;

import javax.inject.Singleton;

import com.maxvandervelde.android.standard.activity.BaseActivity;
import com.maxvandervelde.android.standard.activity.MainActivity;
import dagger.Module;
import dagger.Provides;

@Module(
    injects = {
        MainActivity.class
    },
    addsTo = ApplicationModule.class,
    complete = false,
    includes = {

    },
    library = true
)
public class ActivityModule
{
    final private BaseActivity activity;

    public ActivityModule(BaseActivity activity)
    {
        this.activity = activity;
    }

    @Provides @Singleton Activity provideActivity()
    {
        return activity;
    }
}
