package com.java_shop.Goods;

import com.java_shop.DbConnection.DBConnectionInput;
import com.java_shop.DbConnection.DbConnection;
import com.java_shop.DbConnection.DbConnectionResult;
import com.java_shop.DbConnection.DbConnectionResultList;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// get /add /update /remove
public class GoodsRepository {
    /**
     * Добавление нового товара
     */
    public static Good add(Good good) throws SQLException {
        String query = "INSERT INTO goods (name, price) VALUES (" + "'" + good.getName() + "', " + good.getPrice() + ")";

        int newGoodId = DbConnection.executeUpdate(query);
        good.setId(newGoodId);

        return good;
    }

    /**
     * Поиск товара по ID
     */
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

    /**
     * Получение всего списка товаров
     */
    public static List<Good> getAll() throws SQLException {
        String query = "SELECT * FROM goods";

        DBConnectionInput input = new DBConnectionInput()
                .addField("good_id", "int")
                .addField("name", "string")
                .addField("price", "int");

        DbConnectionResultList resultList = DbConnection.executeQueryList(query, input);

        List<Good> goods = new ArrayList<Good>();

        for (DbConnectionResult result: resultList.getList()) {
            int goodId = result.getFieldInt("good_id");
            String name = result.getFieldString("name");
            int price = result.getFieldInt("price");

            Good good = new Good(goodId, name, price);

            goods.add(good);
        }

        return goods;
    }
}
