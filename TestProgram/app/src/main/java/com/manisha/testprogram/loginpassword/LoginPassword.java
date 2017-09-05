package com.manisha.testprogram.loginpassword;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.manisha.testprogram.R;
import com.manisha.testprogram.passdb.AppDataBase;
import com.manisha.testprogram.passdb.DatabaseInitializer;
import com.manisha.testprogram.passdb.PasswordData;


import java.util.List;
import java.util.Locale;

//import static com.manisha.testprogram.passdb.DatabaseInitializer.addPassword;

/**
 * Created by Manisha on 9/3/2017.
 */

public class LoginPassword extends Fragment {
    View loginPassScreen;
    EditText etEnterPass;
    Button btnPassSubmit;
    Context loginPassContext;
    public static String MasterPasswordValue = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        loginPassScreen = inflater.inflate(R.layout.password_layout, container, false);
        loginPassContext = getActivity();
        etEnterPass = (EditText) loginPassScreen.findViewById(R.id.etPassEnter);
        MasterPasswordValue = etEnterPass.getText().toString();
        Log.d("ConfPassword value"," password " + MasterPasswordValue);
        btnPassSubmit = (Button) loginPassScreen.findViewById(R.id.btnSubmitPass);
        btnPassSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Note: Db references should not be in an activity.
                Log.d("ConfPassword value"," password " +MasterPasswordValue);
                MasterPasswordValue = etEnterPass.getText().toString();
                ConfirmPassword confirmPassword = new ConfirmPassword();
                getFragmentManager().beginTransaction().replace(R.id.main_activity, confirmPassword)
                        .addToBackStack("passwordScreen").commit();
            }
        });
        return loginPassScreen;
    }


}
