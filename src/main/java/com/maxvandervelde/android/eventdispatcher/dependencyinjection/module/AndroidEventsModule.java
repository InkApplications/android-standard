package com.maxvandervelde.android.eventdispatcher.dependencyinjection.module;

import javax.inject.Singleton;

import com.squareup.otto.Bus;
import dagger.Module;
import dagger.Provides;

/**
 * AndroidEventsModule
 *
 * @author Maxwell.Vandervelde <Maxwell.Vandervelde@Nerdery.com>
 */
@Module(library = true)
public class AndroidEventsModule
{
    @Provides @Singleton Bus provideStandardBus()
    {
        Bus applicationBus = new Bus();

        return applicationBus;
    }
}
