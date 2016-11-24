package com.nd.cashc.Activities;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.nd.cashc.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button databaseBtn = (Button) findViewById(R.id.DB_btn);
        if(databaseBtn != null)
            databaseBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(),DBActivity.class);
                        startActivity(intent);
                }
            });

        Button viewShops = (Button) findViewById(R.id.view_shops);
        if(viewShops != null)
            viewShops.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(),ShopsActivity.class);
                    startActivity(intent);
                }
            });




        View actionBar = getSupportActionBar().getCustomView();
        actionBar.findViewById(R.id.up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "selected UP", Toast.LENGTH_SHORT).show();
            }
        });

        actionBar.findViewById(R.id.home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "selected HOME", Toast.LENGTH_SHORT).show();
            }
        });

        actionBar.findViewById(R.id.mytext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "selected Title", Toast.LENGTH_SHORT).show();
            }
        });






    }



    public void ViewHolder(){


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }





}
