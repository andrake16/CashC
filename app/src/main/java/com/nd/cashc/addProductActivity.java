package com.nd.cashc;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nd.cashc.DataBase.CC_DatabaseHelper;
import com.nd.cashc.DataBase.Entities.Purchases;

public class addProductActivity extends AppCompatActivity {

    private ViewHolder viewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        viewHolder = new ViewHolder();

        viewHolder.addRecBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddRecord();
            }
        });
    }

    private void onAddRecord(){
        SQLiteOpenHelper dbHelper = new CC_DatabaseHelper(this.getApplicationContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.insert(Purchases.tables.TABLE_NAME_PURCHASES,Purchases.tables.)

    }

    private class ViewHolder {
        EditText productName = (EditText) findViewById(R.id.editText_Product);
        EditText amount = (EditText) findViewById(R.id.editTextAmount);
        EditText price = (EditText) findViewById(R.id.editTextPrice);
        Button addRecBtn = (Button) findViewById(R.id.buttonAddRecord);
    }
}
