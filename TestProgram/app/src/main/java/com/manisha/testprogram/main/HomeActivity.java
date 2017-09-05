package com.manisha.testprogram.main;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.manisha.testprogram.R;

/**
 * Created by Dell on 9/4/2017.
 */

public class HomeActivity extends Fragment {
     TextView etWelcome;
     ImageView imgHome;
     Context homeContext;
     View homeView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeView = inflater.inflate(R.layout.home_activity, container, false);
        homeContext = getActivity();
        etWelcome = (TextView) homeView.findViewById(R.id.etHome);
        imgHome = (ImageView) homeView.findViewById(R.id.imgHome);
        imgHome.setImageResource(R.drawable.fotolia);
        return homeView;
    }
    @Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        if (args != null) {
            etWelcome.setText(args.getString("WELCOME"));
        }
    }
}
