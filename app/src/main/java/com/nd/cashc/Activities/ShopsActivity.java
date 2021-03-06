package com.nd.cashc.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.nd.cashc.Entities.Shop;
import com.nd.cashc.R;
import com.nd.cashc.ShopListAdapter;

import java.util.ArrayList;
import java.util.List;

public class ShopsActivity extends AppCompatActivity {

    private List<Shop> shopList;
    private ShopListAdapter shopListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shops);

        populateShops();
        shopListAdapter = new ShopListAdapter(this,shopList);

        ListView shopsListView = (ListView) findViewById(R.id.shops_listView);
        shopsListView.setAdapter(shopListAdapter);

        shopsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"selected " + shopList.get(position).getRating(), Toast.LENGTH_SHORT).show();
            }
        });



    }

    private void populateShops() {
        shopList = new ArrayList<Shop>();

            shopList.add(new Shop("ТЦ Город", "Томск, Герцена, 61/1", 4, "cheap, at weekends many peoples"));
            shopList.add(new Shop("ЦОТ", "Томск, Красноармейская, 44", 3, "not bad"));

    }
}
