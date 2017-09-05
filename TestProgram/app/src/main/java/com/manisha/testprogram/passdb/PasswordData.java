package com.manisha.testprogram.passdb;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.renderscript.Sampler;

import java.io.Serializable;

/**
 * Created by Manisha on 9/3/2017.
 */

@Entity(tableName = "PASSWORDTABLE", indices = {@Index(value = {"password"}, unique = true)})
public class PasswordData implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int serialId;

    @ColumnInfo(name = "password")
    private String passwordValue;

    public int getSerialId() {
        return serialId;
    }

    public void setSerialId(int serialId) {
        this.serialId = serialId;
    }

    public String getPasswordValue() {
        return passwordValue;
    }

    public void setPasswordValue(String passwordValue) {
        this.passwordValue = passwordValue;
    }

}

