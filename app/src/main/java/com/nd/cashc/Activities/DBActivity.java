package com.nd.cashc.Activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.nd.cashc.R;

public class DBActivity extends AppCompatActivity {

    private ViewHolder viewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        viewHolder = new ViewHolder();

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle("Database Screen");
            ab.setDisplayShowHomeEnabled(true);
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setDisplayUseLogoEnabled(true);
            ab.setLogo(R.mipmap.ic_launcher);
            //ab.setHomeAsUpIndicator(R.mipmap.main_screen_icn);
        }

        viewHolder.btnAddRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),addProductActivity.class);
                startActivity(intent);
            }
        });

        viewHolder.btnViewRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),ViewPurchasesActivity.class);
                startActivity(intent);
            }
        });
    }

    private class ViewHolder {
        Button btnAddRecord = (Button) findViewById(R.id.buttonAddRecord);
        Button createDB = (Button) findViewById(R.id.buttonCreateDB);
        Button btnViewRecords = (Button) findViewById(R.id.buttonViewRecords);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
}
