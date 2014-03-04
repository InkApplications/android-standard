package com.maxvandervelde.android.eventdispatcher.event.activity;

import android.app.Activity;

/**
 * OnStartEvent
 *
 * @author Maxwell.Vandervelde <Maxwell.Vandervelde@Nerdery.com>
 */
public class OnStartEvent extends ActivityEvent
{
    public OnStartEvent(Activity activity)
    {
        super(activity);
    }
}
