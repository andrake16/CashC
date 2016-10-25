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

        List<HashMap<String,String>> items = new ArrayList<HashMap<String,String>>();

        HashMap<String,String> purchases = new HashMap<>();
        purchases.put("NAME","abc");
        items.add(purchases);

        purchases = new HashMap<>();
        purchases.put("NAME","def");
        items.add(purchases);

        //Log.d("TAGGG", items.toString());


        /*
        SimpleAdapter adapter = new SimpleAdapter(this,items,
                R.layout.item_of_purchases_list,
                new String[] {"NAME"},
                new int[] {R.id.purchaseName});
        */

        SimpleAdapter adapter = new SimpleAdapter(this,items,
                R.layout.item_of_purchases_list,
                new String[] {Purchases.tables._ID, Purchases.tables.PRODUCT, Purchases.tables.AMOUNT, Purchases.tables.PRICE},
                new int[] {R.id.purchase_id,R.id.purchase_name,R.id.purchase_amount,R.id.purchase_price});

        viewHolder.listViewPurchases.setAdapter(adapter);
        getAllPurchases();


    }


    private class ViewHolder {
        private ListView listViewPurchases = (ListView) findViewById(R.id.listView_purchases);
    }


    public List<HashMap<String,Purchase>> getAllPurchases() {
        String SQL_getAllPurchases = "SELECT * FROM " + Purchases.tables.TABLE_NAME_PURCHASES;
        //SQLiteDatabase db = new CC_DatabaseHelper(getApplicationContext()).getReadableDatabase();
        SQLiteDatabase db = App.getReadableDB();
        Cursor cursor = db.query(Purchases.tables.TABLE_NAME_PURCHASES,null,null,null,null,null,null);


        List<HashMap<String,Purchase>> purchases = new ArrayList<HashMap<String, Purchase>>();
        cursor.moveToFirst();
        HashMap map = new HashMap<String,Purchase>();
        for(int recNum = 0; recNum< cursor.getCount(); recNum++)
            for(int columnNum = 0; columnNum< cursor.getColumnCount(); columnNum++)
                if(columnNum == 0)
                    purchase.setId( cursor.getInt(columnNum) );
                else if(columnNum == 1)
                    purchase.setName(cursor.getString(columnNum));
                else if(columnNum == 2)
                    purchase.setAmount(cursor.getInt(columnNum));
                else if(columnNum == 3)
                    purchase.setPrice(cursor.getFloat(columnNum));
            purchases.add(purchase);

        return purchases;







    }
}
