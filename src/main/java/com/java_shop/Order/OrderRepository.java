package com.java_shop.Order;

import com.java_shop.Client.Client;
import com.java_shop.DbConnection.DBConnectionInput;
import com.java_shop.DbConnection.DbConnection;
import com.java_shop.DbConnection.DbConnectionResult;
import com.java_shop.DbConnection.DbConnectionResultList;
import com.java_shop.Order.DTOs.OutputGetAllOrders;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    /**
     * Создание нового заказа
     */
    public static Order add(Order order) throws SQLException {
        String values = order.getClientId() + "," + order.getSum() + ",'" + order.getStatus() + "','" + order.getCartValuesJSON() + "'";
        String query = "INSERT INTO orders (client_id, sum, status, cart) VALUES (" + values + ")";

        int newOrderId = DbConnection.executeUpdate(query);
        order.setId(newOrderId);

        return order;
    }

    /**
     * Получение списка всех заказов
     */
    public static List<OutputGetAllOrders> getAll() throws SQLException {
        String query = "SELECT * FROM orders INNER JOIN clients ON clients.client_id = orders.client_id";

        DBConnectionInput input = new DBConnectionInput()
                .addField("order_id", "int")
                .addField("sum", "int")
                .addField("status", "string")
//                .addField("cart", "string")
                .addField("client_id", "int")
                .addField("name", "string")
                .addField("surname", "string")
                .addField("address", "string")
                .addField("phone", "string");

        DbConnectionResultList resultList = DbConnection.executeQueryList(query, input);

        List<OutputGetAllOrders> orders = new ArrayList<OutputGetAllOrders>();

        for (DbConnectionResult result: resultList.getList()) {
            Client client = new Client(
                result.getFieldInt("client_id"),
                result.getFieldString("name"),
                result.getFieldString("surname"),
                result.getFieldString("address"),
                result.getFieldString("phone")
            );

            OutputGetAllOrders output = new OutputGetAllOrders(
                result.getFieldInt("order_id"),
                result.getFieldInt("sum"),
                OrderStatus.valueOf(result.getFieldString("status")),
                client
            );

            orders.add(output);
        }

        return orders;
    }

    /**
     * Изменение статуса заказа
     */
    public static boolean changeStatus(int orderId, OrderStatus status) throws SQLException {
        String query = "UPDATE orders SET status = '" + status + "' WHERE order_id = " + orderId;

        int id = DbConnection.executeUpdate(query);

        return id != 0;
    }
}
