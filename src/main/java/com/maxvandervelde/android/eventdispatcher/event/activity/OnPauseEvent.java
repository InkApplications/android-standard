package com.maxvandervelde.android.eventdispatcher.event.activity;

import android.app.Activity;

/**
 * OnPauseEvent
 *
 * @author Maxwell.Vandervelde <Maxwell.Vandervelde@Nerdery.com>
 */
public class OnPauseEvent extends ActivityEvent
{
    public OnPauseEvent(Activity activity)
    {
        super(activity);
    }
}
