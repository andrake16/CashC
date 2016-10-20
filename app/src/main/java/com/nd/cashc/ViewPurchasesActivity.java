package com.nd.cashc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.nd.cashc.DataBase.Entities.Purchase;

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
        purchases.put("NAME","def");



        SimpleAdapter adapter = new SimpleAdapter(this,items,
                R.layout.item_of_purchases_list,
                new String[] {"NAME"},
                new int[] {R.id.purchaseName});

        viewHolder.listViewPurchases.setAdapter(adapter);


    }


    private class ViewHolder {
        private ListView listViewPurchases = (ListView) findViewById(R.id.listView_purchases);
    }
}
