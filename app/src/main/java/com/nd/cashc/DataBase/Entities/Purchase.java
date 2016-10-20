package com.nd.cashc.DataBase.Entities;

/**
 * Created by ND on 10/20/2016.
 */

public class Purchase {

    private String name;
    private int amount;
    private float price;

    public Purchase(String name, int amount, float price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }
}
