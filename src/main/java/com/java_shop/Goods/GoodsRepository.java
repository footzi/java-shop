package com.java_shop.Goods;

import com.java_shop.DbConnection.DBConnectionInput;
import com.java_shop.DbConnection.DbConnection;
import com.java_shop.DbConnection.DbConnectionResult;

import java.sql.SQLException;

// get /add /update /remove
public class GoodsRepository {
    public static Good add(Good good) throws SQLException {
        String query = "INSERT INTO goods (name, price) VALUES (" + "'" + good.getName() + "', " + good.getPrice() + ")";

        int newGoodId = DbConnection.executeUpdate(query);
        good.setId(newGoodId);

        return good;
    }

    public static Good getById(int id) throws SQLException {
        String query = "SELECT * FROM goods WHERE good_id = " + id;

        DBConnectionInput input = new DBConnectionInput()
                .addField("good_id", "int")
                .addField("name", "string")
                .addField("price", "int");
        DbConnectionResult result = DbConnection.executeQuery(query, input);

        int goodId = result.getFieldInt("good_id");
        String name = result.getFieldString("name");
        int price = result.getFieldInt("price");

        return new Good(goodId, name, price);
    }
}
