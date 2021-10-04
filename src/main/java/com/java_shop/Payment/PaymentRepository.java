package com.java_shop.Payment;

import com.java_shop.DbConnection.DBConnectionInput;
import com.java_shop.DbConnection.DbConnection;
import com.java_shop.DbConnection.DbConnectionResult;
import com.java_shop.Goods.Good;
import com.java_shop.Order.OrderStatus;

import java.sql.SQLException;

public class PaymentRepository {
    /**
     * Создание нового платежа
     */
    public static Payment add(Payment payment) throws SQLException {
        String values = payment.getOrderId() + ",'" + payment.getStatus() + "'," + payment.getSum();
        String query = "INSERT INTO payments (order_id, status, sum) VALUES (" + values + ")";

        int newOrderId = DbConnection.executeUpdate(query);
        payment.setId(newOrderId);

        return payment;
    }

    /**
     * Получение платежа по Id
     */
    public static Payment getById(int paymentId) throws SQLException {
        String query = "SELECT * FROM payments WHERE payment_id = '" + paymentId + "'";

        DBConnectionInput input = new DBConnectionInput()
            .addField("payment_id", "int")
            .addField("order_id", "int")
            .addField("status", "string")
            .addField("sum", "int");


        DbConnectionResult result = DbConnection.executeQuery(query, input);

        return new Payment(
            result.getFieldInt("payment_id"),
            result.getFieldInt("order_id"),
            result.getFieldInt("sum"),
            PaymentStatus.valueOf(result.getFieldString("status"))
        );
    }

    /**
     * Изменение статуса платежа
     */
    public static boolean changeStatus(int paymentId, PaymentStatus status) throws SQLException {
        String query = "UPDATE payments SET status = '" + status + "' WHERE payment_id = " + paymentId;

        int id = DbConnection.executeUpdate(query);

        return id != 0;
    }
}
