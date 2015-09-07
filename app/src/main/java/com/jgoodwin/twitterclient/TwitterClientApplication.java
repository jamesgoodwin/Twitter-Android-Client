package com.jgoodwin.twitterclient;

import android.app.Application;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import io.fabric.sdk.android.Fabric;

public class TwitterClientApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        TwitterAuthConfig authConfig =
                new TwitterAuthConfig("u2RHSDMeY40mJooIcn06VJzgD",
                        "nlATyUFhqvz4vk6bdEBACFPfHzB6c5nzI69Je476yKSNuXkNDs");

        Fabric.with(this, new Twitter(authConfig));
    }

}
