package com.nd.cashc;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.nd.cashc.DataBase.CC_DatabaseHelper;
import com.nd.cashc.DataBase.DBEntities.Purchases;
import com.nd.cashc.DataBase.Entities.Purchase;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ViewPurchasesActivity extends AppCompatActivity {

    ViewHolder viewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_purchases);
        viewHolder = new ViewHolder();





        List<Purchase> allPurchases = getAllPurchases();
        ArrayAdapter<Purchase> adapter = new PurchasesListAdapter(this,
                R.layout.item_of_purchases_list,
                allPurchases);




        viewHolder.listViewPurchases.setAdapter(adapter);



    }


    private class ViewHolder {
        private ListView listViewPurchases = (ListView) findViewById(R.id.listView_purchases);
    }


    public List<Purchase> getAllPurchases() {
        String SQL_getAllPurchases = "SELECT * FROM " + Purchases.tables.TABLE_NAME_PURCHASES;
        //SQLiteDatabase db = new CC_DatabaseHelper(getApplicationContext()).getReadableDatabase();
        SQLiteDatabase db = App.getReadableDB();
        Cursor cursor = db.query(Purchases.tables.TABLE_NAME_PURCHASES,null,null,null,null,null,null);
        cursor.moveToFirst();

        List<Purchase> purchases = new ArrayList<Purchase>();
        Purchase purchase;

        for(int recNum = 0; recNum< cursor.getCount(); recNum++) {
                purchase = new Purchase();
                purchase.setId(cursor.getInt(0));
                purchase.setName(cursor.getString(1));
                purchase.setAmount(cursor.getInt(2));
                purchase.setPrice(cursor.getFloat(3));

                purchases.add(purchase);
                cursor.moveToNext();
        }

        cursor.close();
        return purchases;







    }
}
