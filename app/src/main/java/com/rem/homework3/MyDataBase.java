package com.rem.homework3;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = MyDataBase.NAME, version = MyDataBase.VERSION)
public class MyDataBase {
    public static final String NAME = "MyDataBase";
    public static final int VERSION = 1;
}

