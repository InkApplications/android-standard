package com.maxvandervelde.android.standard.dependencyinjection.module;

import com.maxvandervelde.android.security.subscriber.ActivityListener;

import javax.inject.Inject;

class EeagerSingletons
{
    @Inject static ActivityListener securityListener;
}
