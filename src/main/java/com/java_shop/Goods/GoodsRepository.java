package com.java_shop.Goods;

import com.java_shop.DbConnection;

// get /add /update /remove
public class GoodsRepository {
    public static Good add(Good good) {
        String query = "INSERT INTO goods (name, price) VALUES (" + "'" + good.getName() + "', " + good.getPrice() + ")";

        int newGoodId = DbConnection.executeUpdate(query);
        good.setId(newGoodId);

        return good;
    }
}
