package com.java_shop.Goods.DTOs;

public class InputCreateGoodDTO {
    private final String name;
    private final int price;

    public InputCreateGoodDTO(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
