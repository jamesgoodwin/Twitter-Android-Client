package com.jgoodwin.twitterclient;

import android.content.Intent;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

public class TwitterLoginDelegate extends Callback<TwitterSession> {

    private final TwitterLoginButton loginButton;
    private final Listener listener;

    public interface Listener {
        void onLoginSuccess(Result<TwitterSession> result);
    }

    public TwitterLoginDelegate(TwitterLoginButton loginButton, Listener listener) {
        this.loginButton = loginButton;
        this.listener = listener;
        this.loginButton.setCallback(this);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        loginButton.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void success(Result<TwitterSession> result) {
        listener.onLoginSuccess(result);
    }

    @Override
    public void failure(TwitterException e) {

    }
}