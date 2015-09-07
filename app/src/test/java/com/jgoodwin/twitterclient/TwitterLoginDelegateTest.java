package com.jgoodwin.twitterclient;

import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TwitterLoginDelegateTest {

    @Test
    public void shouldSetCallbackOnLoginButton() {
        TwitterLoginButton loginButton = mock(TwitterLoginButton.class);

        TwitterLoginDelegate delegate = new TwitterLoginDelegate(loginButton,
                mock(TwitterLoginDelegate.Listener.class));

        verify(loginButton).setCallback(delegate);
    }

}