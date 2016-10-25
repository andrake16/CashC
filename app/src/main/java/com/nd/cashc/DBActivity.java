package com.nd.cashc;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DBActivity extends AppCompatActivity {

    private ViewHolder viewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        viewHolder = new ViewHolder();

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
}
