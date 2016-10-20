package com.nd.cashc.DataBase.DBEntities;

import android.provider.BaseColumns;

/**
 * Created by ND on 10/18/2016.
 */

public final class Purchases {

    public static final class tables implements BaseColumns {

        public static final String TABLE_NAME_PURCHASES = "purchases";
        public static final String PRODUCT = "product";
        public static final String AMOUNT = "amount";
        public static final String PRICE = "price";

        public static final String  COLUMN_NAME_NULLABLE = "product";

        public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NAME_PURCHASES + "(" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PRODUCT + " TEXT, " +
                AMOUNT + " INTEGER, " +
                PRICE + " REAL" +
                ");";
    }
}
