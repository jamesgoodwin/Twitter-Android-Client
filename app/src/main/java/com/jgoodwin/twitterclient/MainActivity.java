package com.jgoodwin.twitterclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity implements TwitterLoginDelegate.Listener {

    @InjectView(R.id.login_button)
    TwitterLoginButton loginButton;

    private TwitterLoginDelegate loginDelegate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        this.loginDelegate = new TwitterLoginDelegate(loginButton, this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        this.loginDelegate.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onLoginSuccess(Result<TwitterSession> result) {
        startActivity(new Intent(this, TweetsActivity.class));
    }

}
