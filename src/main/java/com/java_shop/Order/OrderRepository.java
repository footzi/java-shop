package com.java_shop.Order;

import com.java_shop.DbConnection.DbConnection;

import java.sql.SQLException;

public class OrderRepository {
    public static Order add(Order order) throws SQLException {
        String values = order.getClientId() + "," + order.getSum() + ",'" + order.getStatus() + "','" + order.getCartValuesJSON() + "'";
        String query = "INSERT INTO orders (client_id, sum, status, cart) VALUES (" + values + ")";

        int newOrderId = DbConnection.executeUpdate(query);
        order.setId(newOrderId);

        return order;
    }
}
