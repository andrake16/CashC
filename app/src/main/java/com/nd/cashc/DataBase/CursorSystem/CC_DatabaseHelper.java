package com.nd.cashc.Database.CursorSystem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Andrew on 15.10.2016.
 */

public class CC_DatabaseHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "CashC_Database";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME_PURCHASES = "purchases";
    private static final String PRODUCT = "product";
    private static final String AMOUNT = "amount";
    private static final String PRICE = "price";

    public CC_DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlRequest = "CREATE TABLE " + TABLE_NAME_PURCHASES + "(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PRODUCT + " TEXT, " +
                AMOUNT + " INTEGER, " +
                PRICE + " REAL, " +
        ");";

        db.execSQL(sqlRequest);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
