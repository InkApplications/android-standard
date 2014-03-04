package com.maxvandervelde.android.eventdispatcher.event.activity;

import android.app.Activity;

/**
 * OnRestartEvent
 *
 * @author Maxwell.Vandervelde <Maxwell.Vandervelde@Nerdery.com>
 */
public class OnRestartEvent extends ActivityEvent
{
    public OnRestartEvent(Activity activity)
    {
        super(activity);
    }
}
