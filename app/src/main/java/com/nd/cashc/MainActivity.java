package com.nd.cashc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button databaseBtn = (Button) findViewById(R.id.DB_btn);
        if(databaseBtn != null)
            databaseBtn.setOnClickListener(this);
    }



    public void ViewHolder(){


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,DBActivity.class);
        startActivity(intent);

    }
}
