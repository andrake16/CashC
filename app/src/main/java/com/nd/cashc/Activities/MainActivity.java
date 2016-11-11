package com.nd.cashc.Activities;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.nd.cashc.R;

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button databaseBtn = (Button) findViewById(R.id.DB_btn);
        if(databaseBtn != null)
            databaseBtn.setOnClickListener(this);


        //ActionBar ab = getSupportActionBar();
        ActionBar ab = getActionBar();

        if (ab != null) {
            //ab.setDisplayHomeAsUpEnabled(true);
            //ab.setLogo(R.mipmap.main_screen_icn);
            //ab.setDisplayShowHomeEnabled(true);
            //ab.setDisplayUseLogoEnabled(true);
            ab.setTitle(R.string.mainScreenTitle);
            //int options = ActionBar.DISPLAY_HOME_AS_UP|ActionBar.DISPLAY_SHOW_HOME|ActionBar.DISPLAY_USE_LOGO;
            //int options = ActionBar.DISPLAY_HOME_AS_UP;
            //ab.setDisplayOptions(options,options);
            ab.setIcon(R.mipmap.ic_launcher);

            ab.setDisplayHomeAsUpEnabled(true);
        }








    }



    public void ViewHolder(){


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,DBActivity.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
}
