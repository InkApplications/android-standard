package com.maxvandervelde.android.eventdispatcher.event.application;

import android.app.Application;

/**
 * OnCreateEvent
 *
 * @author Maxwell.Vandervelde <Maxwell.Vandervelde@Nerdery.com>
 */
public class OnCreateEvent extends ApplicationEvent
{
    public OnCreateEvent(Application application)
    {
        super(application);
    }
}
