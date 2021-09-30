package com.java_shop.Payment;

import com.java_shop.DbConnection.DbConnection;

import java.sql.SQLException;

public class PaymentRepository {
    public static void add(Payment payment) throws SQLException {
        String values = payment.getClientId() + ",'" + payment.getStatus() + "'," + payment.getSum();
        String query = "INSERT INTO payments (client_id, status, sum) VALUES (" + values + ")";

        System.out.println(query);
//
//        int newOrderId = DbConnection.executeUpdate(query);
//        order.setId(newOrderId);
//
//        return order;
    }
}
