package com.nd.cashc;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nd.cashc.DataBase.CC_DatabaseHelper;
import com.nd.cashc.DataBase.DBEntities.Purchases;


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

        ContentValues values = new ContentValues();

        values.put(Purchases.tables.PRODUCT, viewHolder.productName.getText().toString());
        values.put(Purchases.tables.AMOUNT, viewHolder.amount.getText().toString());
        values.put(Purchases.tables.PRICE,viewHolder.price.getText().toString());
        db.insert(Purchases.tables.TABLE_NAME_PURCHASES,Purchases.tables.COLUMN_NAME_NULLABLE,values);

        finish();

    }

    private class ViewHolder {
        EditText productName = (EditText) findViewById(R.id.addProd_editText_Product);
        EditText amount = (EditText) findViewById(R.id.addProd_editText_Amount);
        EditText price = (EditText) findViewById(R.id.addProd_editText_Price);
        Button addRecBtn = (Button) findViewById(R.id.button_add_product);



    }
}
