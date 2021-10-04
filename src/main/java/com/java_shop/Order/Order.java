package com.java_shop.Order;

import com.google.gson.Gson;
import com.java_shop.Cart.CartValues;

import java.util.List;

public class Order {
    int id;
    int clientId;
    int sum;
    List<CartValues> cartValues;
    OrderStatus status;

    Order(int id, int clientId, int sum, List<CartValues> cartValues, OrderStatus status) {
        this.id = id;
        this.clientId = clientId;
        this.sum = sum;
        this.cartValues = cartValues;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getClientId() {
        return this.clientId;
    }

    public int getSum() {
        return this.sum;
    }

    public List<CartValues> getCartValues() {
        return this.cartValues;
    }

    public String getCartValuesJSON() {
        Gson gson = new Gson();
        return gson.toJson(this.cartValues);
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    public void setId(int id) {
        this.id = id;
    }
}
