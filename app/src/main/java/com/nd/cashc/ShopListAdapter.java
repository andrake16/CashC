package com.nd.cashc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

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
        if(convertView==null)
            convertView = LayoutInflater.from(ctx).inflate(R.layout.item_of_shops_list,null);
        TextView nameTV = (TextView) convertView.findViewById(R.id.name);
        TextView locationTV = (TextView) convertView.findViewById(R.id.location);
        RatingBar ratingBar = (RatingBar) convertView.findViewById(R.id.ratingBar);

        nameTV.setText(shopList.get(position).getName());
        locationTV.setText(shopList.get(position).getLocation());
        ratingBar.setRating(shopList.get(position).getRating());

        return convertView;
    }
}
