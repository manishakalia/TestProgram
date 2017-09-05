package com.manisha.testprogram.splashui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.manisha.testprogram.R;
import com.manisha.testprogram.loginpassword.LoginPassword;
import com.manisha.testprogram.main.MainActivity;

/**
 * Created by Manisha on 9/3/2017.
 */

public class SplashScreen extends Activity{
    TextView splashImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        setText(R.string.splash_alpha);
        final int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                setText(R.string.splash_beta);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(SplashScreen.this,
                                MainActivity.class));

                        finish();
                    }
                },secondsDelayed * 2000);
            }
        }, secondsDelayed * 2000);

    }
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
    private void setText(final int text) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ((TextView) findViewById(R.id.tvAlpha)).setText(text);
            }
        });
    }


}
