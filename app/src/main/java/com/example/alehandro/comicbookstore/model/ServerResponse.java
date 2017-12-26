package com.example.alehandro.comicbookstore.model;

import java.util.ArrayList;

/**
 * Created by alehandro on 26.12.17..
 */

public class ServerResponse {

    private int success;
    private ArrayList<Comic> cart;


    public ServerResponse(int success, ArrayList<Comic> cart) {
        this.success = success;
        this.cart = cart;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public ArrayList<Comic> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Comic> cart) {
        this.cart = cart;
    }
}
