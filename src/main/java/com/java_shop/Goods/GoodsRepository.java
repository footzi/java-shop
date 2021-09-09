package com.java_shop.Goods;

import com.java_shop.DbConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GoodsRepository {

//    private final Statement statement;

    GoodsRepository() {
//        this.statement = new DbConnection().connect();
    }

    public static void saveGood(String name, int price) {
//        String query = "INSERT INTO goods (name, price) VALUES ('test', 100)";
        String query = "INSERT INTO goods (name, price) VALUES (" + "'" + name + "', " + price + ")";

        System.out.println(query);
//        String query = "SELECT * FROM goods";

        DbConnection.executeUpdate(query);

//        System.out.println(resultSet);

//        try(ResultSet resultSet = this.statement.executeQuery(QUERY);) {
//            System.out.println(resultSet);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
