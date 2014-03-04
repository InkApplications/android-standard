package com.maxvandervelde.android.eventdispatcher.event.application;

import android.app.Application;

/**
 * ApplicationEvent
 *
 * @author Maxwell.Vandervelde <Maxwell.Vandervelde@Nerdery.com>
 */
public class ApplicationEvent
{
    private Application application;

    public ApplicationEvent(Application application)
    {
        this.application = application;
    }

    final public Application getApplication()
    {
        return this.application;
    }
}
