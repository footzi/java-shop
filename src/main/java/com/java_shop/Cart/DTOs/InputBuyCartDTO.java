package com.java_shop.Cart.DTOs;

import com.java_shop.Client.Client;

import java.util.List;

public class InputBuyCartDTO {
    private List<Integer> values;
    private Client client;

    public List<Integer> getValues() {
        return values;
    }

    public Client getClient() {
        return client;
    }
}
