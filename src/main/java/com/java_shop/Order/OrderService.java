package com.java_shop.Order;

import com.java_shop.Cart.CartValues;
import com.java_shop.Cart.DTOs.InputBuyCartDTO;
import com.java_shop.Goods.GoodsService;
import com.java_shop.Order.DTOs.OutputGetAllOrders;

import java.sql.SQLException;
import java.util.List;

public class OrderService {
    // Плохо ли то что тут DTO из другого класса?
    /**
     * Создание нового заказа
     */
    public static Order add(InputBuyCartDTO inputBuyCartDTO) throws SQLException {
        int sum = OrderService.calcSum(inputBuyCartDTO.getValues());

        Order order = new Order(0, inputBuyCartDTO.getClientId(), sum, inputBuyCartDTO.getValues(), OrderStatus.CREATED);

        return OrderRepository.add(order);
    }


    /**
     * Расчет стоимости заказа
     */
    public static int calcSum(List<CartValues> cartValues) throws SQLException {
        int sum = 0;

        for (CartValues cartValue : cartValues) {
            int goodId = cartValue.getGoodId();
            int count = cartValue.getCount();
            int price = GoodsService.getById(goodId).getPrice();

            sum = sum + (price * count);
        }

        return sum;
    }

    /**
     * Получение списка всех заказов
     */
    public static List<OutputGetAllOrders> getAll() throws SQLException {
        return OrderRepository.getAll();
    }

    /**
     * Установка статуса "PAID"
     */
    public static boolean setPayStatus(int orderId) throws SQLException {
        return OrderRepository.changeStatus(orderId, OrderStatus.PAID);
    }
}
