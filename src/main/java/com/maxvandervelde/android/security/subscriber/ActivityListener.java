package com.maxvandervelde.android.security.subscriber;

import com.maxvandervelde.android.eventdispatcher.event.activity.OnResumeEvent;
import com.maxvandervelde.android.security.provider.AuthenticationProvider;
import com.squareup.otto.Subscribe;

/**
 * ActivityListener
 *
 * @author Maxwell.Vandervelde <Maxwell.Vandervelde@Nerdery.com>
 */
public class ActivityListener
{
    private AuthenticationProvider<?> authenticationProvider;

    public ActivityListener(AuthenticationProvider<?> authenticationProvider)
    {
        this.authenticationProvider = authenticationProvider;
    }

    @Subscribe
    public void onActivityResume(OnResumeEvent event)
    {
        authenticationProvider.authenticate(null);
    }
}
