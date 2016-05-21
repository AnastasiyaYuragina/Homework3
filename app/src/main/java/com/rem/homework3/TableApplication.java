package com.rem.homework3;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = MyDataBase.class)
public class TableApplication extends BaseModel {

    @Column
    @PrimaryKey
    int id;

    @Column
    String name;

    public void setName(String name) {
        this.name = name;
    }
}
