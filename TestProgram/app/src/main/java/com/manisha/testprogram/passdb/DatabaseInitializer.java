package com.manisha.testprogram.passdb;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import static com.manisha.testprogram.constant.ErrorCode.DTAT_ALREADY_PRESENT;
import static com.manisha.testprogram.constant.ErrorCode.DTAT_BASE_ERROR;

/**
 * Created by Manisha on 9/3/2017.
 */

public class DatabaseInitializer {
    private Context context;
    private AppDataBase appDataBase;

    public  void databaseInitialize() {

        appDataBase=AppDataBase.getInMemoryDatabase(context);
    }

    public DatabaseInitializer(Context context) {
        /*populateWithTestData(db);*/
        this.context=context;
    }



    public int addPassword( final PasswordData password) {
        int responceCode=0;
        try{
            appDataBase.passwordModel().PasswordData(password);

        }catch (SQLiteConstraintException ex){
            Log.e("EX",ex.getMessage());
            responceCode= DTAT_ALREADY_PRESENT;
        }catch (IllegalStateException ex){
            Log.e("EXIll",ex.getMessage());
            responceCode= DTAT_BASE_ERROR;
        }
        Log.e("Responce",""+responceCode);
        return responceCode;

    }
    /*private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final AppDataBase mDb;

        PopulateDbAsync(AppDataBase db) {
            mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb,"manisha");
            return null;
        }
    }
    private static void populateWithTestData(AppDataBase db,String password) {

        PasswordData pass = addPassword(db,*//*serialid,*//*password);


    }
*/

    }
