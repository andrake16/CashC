package com.nd.cashc;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.nd.cashc.DataBase.CC_DatabaseHelper;

/**
 * Created by ND on 10/25/2016.
 */

public class App extends Application{

    private static CC_DatabaseHelper dbHelper = null;
    private static App appInstance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        DBHelperHolder.setHelper(getApplicationContext());
    }

    public static App getAppInstance() {
        if(appInstance == null)
            appInstance = new App();
        return appInstance;
    }

    private CC_DatabaseHelper getDBHelper() {
        if(dbHelper == null)
            dbHelper = new CC_DatabaseHelper(getBaseContext());
        return dbHelper;
    }

    public static SQLiteDatabase getReadableDB() {
        return  DBHelperHolder.getHelper().getReadableDBInstance();
    }





}
