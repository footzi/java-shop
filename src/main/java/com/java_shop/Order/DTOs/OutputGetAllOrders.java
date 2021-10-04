package com.java_shop.Order.DTOs;

import com.java_shop.Cart.CartValues;
import com.java_shop.Client.Client;
import com.java_shop.Order.OrderStatus;

import java.util.List;

public class OutputGetAllOrders {
    int id;
    int sum;
//    List<CartValues> cartValues;
    OrderStatus status;
    Client client;

    public OutputGetAllOrders(int id, int sum, OrderStatus status, Client client) {
        this.id = id;
        this.sum = sum;
//        this.cartValues = cartValues;
        this.status = status;
        this.client = client;
    }
}
