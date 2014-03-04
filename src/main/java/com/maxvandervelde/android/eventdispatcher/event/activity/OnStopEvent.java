package com.maxvandervelde.android.eventdispatcher.event.activity;

import android.app.Activity;

/**
 * OnStopEvent
 *
 * @author Maxwell.Vandervelde <Maxwell.Vandervelde@Nerdery.com>
 */
public class OnStopEvent extends ActivityEvent
{
    public OnStopEvent(Activity activity)
    {
        super(activity);
    }
}
