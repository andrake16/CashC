package com.nd.cashc;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.nd.cashc.Entities.Shop;

import java.util.List;
import com.google.common.base.Objects;


/**
 * Created by ND on 11/23/2016.
 */

public class ShopListAdapter extends BaseAdapter {

    private Context ctx;
    private List<Shop> shopList;

    public ShopListAdapter(Context ctx, List<Shop> shopList) {
        this.ctx = ctx;
        this.shopList = shopList;

    }

    @Override
    public int getCount() {
        return shopList.size();
    }

    @Override
    public Shop getItem(int position) {
        return shopList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Objects.hashCode( shopList.get(position).getId().toString() );
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("GETVIEW:", "Getview is Called" );
        if(convertView==null)
            convertView = LayoutInflater.from(ctx).inflate(R.layout.item_of_shops_list,null);
        TextView nameTV = (TextView) convertView.findViewById(R.id.name);
        TextView locationTV = (TextView) convertView.findViewById(R.id.location);
        RatingBar ratingBar = (RatingBar) convertView.findViewById(R.id.ratingBar);
        ImageView delBtn = (ImageView) convertView.findViewById(R.id.delImageView);

        final Shop shop = shopList.get(position);
        nameTV.setText(shop.getName());
        locationTV.setText(shop.getLocation());
        ratingBar.setRating(shop.getRating());


        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ctx,"rating is " + shop.getRating(),Toast.LENGTH_SHORT).show();
            }
        });


        return convertView;
    }
}
