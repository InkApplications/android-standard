package com.maxvandervelde.android.eventdispatcher.event.activity;

import android.app.Activity;

/**
 * ActivityEvent
 *
 * @author Maxwell.Vandervelde <Maxwell.Vandervelde@Nerdery.com>
 */
public class ActivityEvent
{
    private Activity activity;

    public ActivityEvent(Activity activity)
    {
        this.activity = activity;
    }

    final public Activity getActivity()
    {
        return this.activity;
    }
}
