package com.maxvandervelde.android.eventdispatcher.event.application;

import android.app.Application;

/**
 * OnTerminateEvent
 *
 * @author Maxwell.Vandervelde <Maxwell.Vandervelde@Nerdery.com>
 */
public class OnTerminateEvent extends ApplicationEvent
{
    public OnTerminateEvent(Application application)
    {
        super(application);
    }
}
