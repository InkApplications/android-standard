package com.maxvandervelde.android.standard.dependencyinjection.registry;

import javax.inject.Inject;

import com.maxvandervelde.android.eventdispatcher.registry.RegistryInterface;
import com.squareup.otto.Bus;

/**
 * ApplicationRegistry
 *
 * @author Maxwell.Vandervelde <Maxwell.Vandervelde@Nerdery.com>
 */
public class ApplicationRegistry implements RegistryInterface
{
    @Inject Bus eventBus;

    @Override
    public void register()
    {
    }
}
