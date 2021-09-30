package com.java_shop.Cart.DTOs;

import com.java_shop.Cart.CartValues;

import java.util.List;

public class InputBuyCartDTO {
    private List<CartValues> values;
    private int clientId;

    public List<CartValues> getValues() {
        return values;
    }

    public int getClientId() {
        return clientId;
    }
}
