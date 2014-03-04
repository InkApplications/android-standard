package com.maxvandervelde.android.eventdispatcher.event.application;

import android.app.Application;

/**
 * OnLowMemoryEvent
 *
 * @author Maxwell.Vandervelde <Maxwell.Vandervelde@Nerdery.com>
 */
public class OnLowMemoryEvent extends ApplicationEvent
{
    public OnLowMemoryEvent(Application application)
    {
        super(application);
    }
}
