package com.nd.cashc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.nd.cashc.DataBase.Entities.Purchase;

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
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if(convertView == null)
            convertView = LayoutInflater.from(ctx).inflate(R.layout.item_of_purchases_list,null);

        EditText et = (EditText) convertView.findViewById(R.id.purchase_id);

        et.setText(purchases.get(position).getId());

        return convertView;
    }
}
