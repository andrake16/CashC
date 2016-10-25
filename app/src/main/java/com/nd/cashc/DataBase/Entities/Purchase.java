package com.nd.cashc.DataBase.Entities;

/**
 * Created by ND on 10/20/2016.
 */

public class Purchase {

    private int id;
    private String name;
    private int amount;
    private float price;

    public Purchase(int id, String name, int amount, float price) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public Purchase() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
