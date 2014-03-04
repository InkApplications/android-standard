package com.maxvandervelde.android.security.provider;

/**
 * AuthenticationProvider
 *
 * @author Maxwell.Vandervelde <Maxwell.Vandervelde@Nerdery.com>
 */
public interface AuthenticationProvider<T>
{
    public void authenticate(T token);
}
