package com.manisha.testprogram.passdb;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;
import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

/**
 * Created by Manisha on 9/3/2017.
 */

@Dao
public interface PasswordInterface{
    @Query("select * from PASSWORDTABLE")
    List<PasswordData> loadAllUsers();

    @Insert
    void PasswordData (PasswordData passwordData);

}
