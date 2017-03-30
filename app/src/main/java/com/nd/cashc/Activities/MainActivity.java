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

import com.google.gson.Gson;
import com.nd.cashc.Entities.Shop;
import com.nd.cashc.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        Callable<String> callable1 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "It's a callable1";
            }
        };

        Callable<String> callable2 = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "It's a callable2";
            }
        };



        ExecutorService es = Executors.newSingleThreadExecutor();

        List<Callable<String>> tasks = Arrays.asList(callable1,callable2);
        List<Future<String>> futures = null;
        try {
             futures = es.invokeAll(tasks,10,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        };

        if (futures != null) {
            for (Future<String> future:futures) {
                try {
                    System.out.println(future.get());
                }catch(Exception e) {
                    e.printStackTrace();
                }


            }
        }

        try {
            System.out.println("attempt to shutdown executor");
            es.shutdown();
            es.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!es.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            es.shutdownNow();
            System.out.println("shutdown finished");
        }



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
