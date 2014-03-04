package com.maxvandervelde.android.security.token;

/**
 * TokenInterface
 *
 * @author Maxwell.Vandervelde <Maxwell.Vandervelde@Nerdery.com>
 */
public interface TokenInterface
{
    public String getUsername();
    public String getCredentials();
    public Boolean isAuthenticated();
}
