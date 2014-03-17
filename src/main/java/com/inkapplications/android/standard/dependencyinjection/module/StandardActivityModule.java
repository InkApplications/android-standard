package com.inkapplications.android.standard.dependencyinjection.module;

import android.app.Activity;

import javax.inject.Singleton;

import com.inkapplications.android.standard.activity.BaseActivity;
import dagger.Module;
import dagger.Provides;

@Module(
    addsTo = StandardApplicationModule.class,
    complete = false,
    library = true
)
public class StandardActivityModule
{
    final private BaseActivity activity;

    public StandardActivityModule(BaseActivity activity)
    {
        this.activity = activity;
    }

    @Provides @Singleton Activity provideActivity()
    {
        return activity;
    }
}
