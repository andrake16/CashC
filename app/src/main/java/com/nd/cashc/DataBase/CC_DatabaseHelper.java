package com.nd.cashc.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.nd.cashc.DataBase.Entities.Purchases;

/**
 * Created by Andrew on 15.10.2016.
 */

public class CC_DatabaseHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "CashC_Database";
    private static final int DATABASE_VERSION = 1;

    public CC_DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Purchases.tables.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
