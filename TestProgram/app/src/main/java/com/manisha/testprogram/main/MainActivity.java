package com.manisha.testprogram.main;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.manisha.testprogram.R;
import com.manisha.testprogram.loginpassword.LoginPassword;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginPassword ecrCategoryScreen = new LoginPassword();
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_activity, ecrCategoryScreen);
        transaction.addToBackStack(null);
        transaction.commit();

    }
    @Override
    public void onBackPressed() {
        // Simply Doing noting!

    }
}
