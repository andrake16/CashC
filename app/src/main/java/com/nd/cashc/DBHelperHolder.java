package com.nd.cashc;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

import com.nd.cashc.DataBase.CC_DatabaseHelper;

/**
 * Created by ND on 10/25/2016.
 */

public class DBHelperHolder {
    private static CC_DatabaseHelper dbHelper = null;

    public static void setHelper(Context ctx) {
        dbHelper = new CC_DatabaseHelper(ctx);
    }

    public static CC_DatabaseHelper getHelper() {
        return dbHelper;
    }
}
