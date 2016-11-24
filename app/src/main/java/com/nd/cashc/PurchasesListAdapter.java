package com.nd.cashc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.nd.cashc.Entities.Purchase;

import java.util.List;

/**
 * Created by ND on 10/27/2016.
 */

public class PurchasesListAdapter extends ArrayAdapter<Purchase> {

    Context ctx;
    List<Purchase> purchases;

    public PurchasesListAdapter(Context context, int resource, List<Purchase> objects) {
        super(context, resource, objects);
        ctx = context;
        purchases = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if(convertView == null)
            convertView = LayoutInflater.from(ctx).inflate(R.layout.item_of_purchases_list,null);

        //LayoutInflater li = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //li.inflate(R.layout.item_of_purchases_list,null);

        EditText purchaseIDWidget = (EditText) convertView.findViewById(R.id.purchase_id);
        EditText purchaseNameWidget = (EditText) convertView.findViewById(R.id.purchase_name);
        EditText purchaseAmountWidget = (EditText) convertView.findViewById(R.id.purchase_amount);
        EditText purchasePriceWidget = (EditText) convertView.findViewById(R.id.purchase_price);


        purchaseIDWidget.setText( String.valueOf( purchases.get(position).getId() ) );
        purchaseNameWidget.setText( String.valueOf( purchases.get(position).getName() ) );
        purchaseAmountWidget.setText( String.valueOf( purchases.get(position).getAmount() ) );
        purchasePriceWidget.setText( String.valueOf( purchases.get(position).getPrice() ) );


        return convertView;
    }
}
