package com.maxvandervelde.android.eventdispatcher.event.activity;

import android.app.Activity;

/**
 * OnDestroyEvent
 *
 * @author Maxwell.Vandervelde <Maxwell.Vandervelde@Nerdery.com>
 */
public class OnDestroyEvent extends ActivityEvent
{
    public OnDestroyEvent(Activity activity)
    {
        super(activity);
    }
}
