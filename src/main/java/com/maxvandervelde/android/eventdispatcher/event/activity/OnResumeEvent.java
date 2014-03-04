package com.maxvandervelde.android.eventdispatcher.event.activity;

import android.app.Activity;

/**
 * OnResumeEvent
 *
 * @author Maxwell.Vandervelde <Maxwell.Vandervelde@Nerdery.com>
 */
public class OnResumeEvent extends ActivityEvent
{
    public OnResumeEvent(Activity activity)
    {
        super(activity);
    }
}
