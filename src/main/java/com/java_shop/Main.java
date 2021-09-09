package com.java_shop;

import com.java_shop.Goods.GoodsController;

public class Main {
    public static void main(String[] args) {
        saveGood();
    }

    public static void saveGood() {
        String body = "{name: 'Chocolate', price: 10000}";
        GoodsController.saveGood(body);
    }

}
