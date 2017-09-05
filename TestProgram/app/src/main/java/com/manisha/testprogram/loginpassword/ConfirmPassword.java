package com.manisha.testprogram.loginpassword;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.manisha.testprogram.R;
import com.manisha.testprogram.main.HomeActivity;
import com.manisha.testprogram.passdb.AppDataBase;
import com.manisha.testprogram.passdb.DatabaseInitializer;
import com.manisha.testprogram.passdb.PasswordData;

import java.util.List;

import static com.manisha.testprogram.constant.ErrorCode.DATA_INSTERTED;
import static com.manisha.testprogram.constant.ErrorCode.DTAT_ALREADY_PRESENT;
import static com.manisha.testprogram.loginpassword.LoginPassword.MasterPasswordValue;

/**
 * Created by Manisha on 9/3/2017.
 */

public class ConfirmPassword extends Fragment {
    View loginConfirmScreen;
    EditText etConfirmPass;
    Button btnCPassSubmit;
    Context confirmPassContext;
    Dialog alertDialog;
    private AppDataBase mDb;
    public String welcomeHome = "WELCOME HOME";
    public String welcomeHomeAgain = "WELCOME AGAIN";

    DatabaseInitializer databaseInitializer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        confirmPassContext = getActivity();

        loginConfirmScreen = inflater.inflate(R.layout.confirm_password, container, false);
        etConfirmPass =  (EditText) loginConfirmScreen.findViewById(R.id.etConfPass);
        etConfirmPass.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
        btnCPassSubmit = (Button) loginConfirmScreen.findViewById(R.id.btnCPassSubmit);
       //Initializing the database
       /* databaseInitializer = new DatabaseInitializer(confirmPassContext);
        databaseInitializer.databaseInitialize();*/
        btnCPassSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // fetchData();

                fetchData(confirmPassContext,etConfirmPass.getText().toString());
                Log.d("confirmPassword " ,"values1 " +etConfirmPass.getText().toString());
            }
        });

        return loginConfirmScreen;
    }
    private void fetchData(Context context,String passwordValue) {
        /*PasswordData pass = new PasswordData();*/

        Log.d("confirmPassword " ,"values2 " + MasterPasswordValue);
        Log.d("confirmPassword " ,"values22 " + passwordValue);
         try {
             if(MasterPasswordValue.equals(passwordValue)){
                 Log.d("confirmPassword " +passwordValue ,"values2 " + MasterPasswordValue);
                // mDb = AppDataBase.getInMemoryDatabase(confirmPassContext);
                 //populateDb();
                 //After confirming the password adding into database
                 databaseInitializer = new DatabaseInitializer(context);
                 databaseInitializer.databaseInitialize();
                 PasswordData pass = new PasswordData();
                 pass.setPasswordValue(passwordValue);
                 Log.d("confirmPassword " ,"values3 " + pass.getPasswordValue());
                 int responceCode=databaseInitializer.addPassword(pass);
                     if (responceCode==DATA_INSTERTED) {
                         Log.d("confirmPassword " ,"response " + DATA_INSTERTED);
                         HomeActivity confirmPassword = new HomeActivity();
                         welcomeHome = "WELCOME HOME";
                         Bundle bundle = new Bundle();
                         bundle.putString("WELCOME", welcomeHome);
                         confirmPassword.setArguments(bundle);
                         getFragmentManager().beginTransaction().replace(R.id.main_activity, confirmPassword)
                                 .addToBackStack("confirmScreen").commit();

                     } else {
                         Log.d("confirmPassword " ,"response1 " + DATA_INSTERTED);
                         HomeActivity confirmPassword = new HomeActivity();
                         welcomeHomeAgain = "WELCOME AGAIN";
                         Bundle bundle = new Bundle();
                         bundle.putString("WELCOME", welcomeHomeAgain);
                         getFragmentManager().beginTransaction().replace(R.id.main_activity, confirmPassword)
                                 .addToBackStack("confirmScreen").commit();

                     }

             }else{
                 AlertDialog.Builder alert = new AlertDialog.Builder(context);
                 alert.setTitle("Error Message");
                 alert.setMessage("The Password doesn't match Re-enter the Password");
                 alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         alertDialog.cancel();
                     }
                 });
                 alertDialog = alert.create();
                 alertDialog.show();
             }
         }catch (NullPointerException ex){
             ex.printStackTrace();
         }
    }
    @Override
    public void onDestroy() {
        AppDataBase.destroyInstance();
        super.onDestroy();
    }

   /* private void populateDb() {
        DatabaseInitializer.populateSync(mDb);

    }
*/
}
