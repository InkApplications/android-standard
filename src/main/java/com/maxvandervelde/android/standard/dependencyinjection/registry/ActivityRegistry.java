package com.maxvandervelde.android.standard.dependencyinjection.registry;

import javax.inject.Inject;

import com.maxvandervelde.android.eventdispatcher.registry.RegistryInterface;
import com.maxvandervelde.android.security.subscriber.ActivityListener;
import com.squareup.otto.Bus;

/**
 * ActivityRegistry
 *
 * @author Maxwell.Vandervelde <Maxwell.Vandervelde@Nerdery.com>
 */
public class ActivityRegistry implements RegistryInterface
{
    @Inject Bus eventBus;
    @Inject ActivityListener securityListener;

    @Override
    public void register()
    {
        this.eventBus.register(this.securityListener);
    }
}
