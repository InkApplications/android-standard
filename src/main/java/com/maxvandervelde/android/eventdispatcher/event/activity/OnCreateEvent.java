package com.maxvandervelde.android.eventdispatcher.event.activity;

import android.app.Activity;
import android.os.Bundle;

/**
 * OnCreateEvent
 *
 * @author Maxwell.Vandervelde <Maxwell.Vandervelde@Nerdery.com>
 */
public class OnCreateEvent extends ActivityEvent
{
    private Bundle savedInstanceState;

    public OnCreateEvent(Activity activity, Bundle savedInstanceState)
    {
        super(activity);
        this.savedInstanceState = savedInstanceState;
    }

    final public Bundle getSavedInstanceState()
    {
        return this.savedInstanceState;
    }
}
