package com.java_shop.Payment;

import com.java_shop.DbConnection.DbConnection;

import java.sql.SQLException;

public class PaymentRepository {
    /**
     * Создание нового платежа
     */
    public static Payment add(Payment payment) throws SQLException {
        String values = payment.getClientId() + ",'" + payment.getStatus() + "'," + payment.getSum();
        String query = "INSERT INTO payments (client_id, status, sum) VALUES (" + values + ")";

        int newOrderId = DbConnection.executeUpdate(query);
        payment.setId(newOrderId);

        return payment;
    }

    /**
     * Изменение статуса платежа
     */
    public static void changeStatus(int paymentId, PaymentStatus status) throws SQLException {
        String query = "UPDATE payments SET status = '" + status + "' WHERE payment_id = " + paymentId;

        DbConnection.executeUpdate(query);
    }
}
