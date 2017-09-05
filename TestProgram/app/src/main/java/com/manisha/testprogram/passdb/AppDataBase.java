package com.manisha.testprogram.passdb;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Manisha on 9/3/2017.
 * This abstract class is used for initializing the database using Room library
 */

@Database(entities = {PasswordData.class}, version = 3)
public abstract class AppDataBase extends RoomDatabase {
    public abstract PasswordInterface passwordModel();
    private static AppDataBase INSTANCE;
    public static AppDataBase getInMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class,"PASSWORDTABLE")
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }
    public static void destroyInstance() {
        INSTANCE = null;
    }
}
