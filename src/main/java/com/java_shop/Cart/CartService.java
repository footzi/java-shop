package com.java_shop.Cart;

import com.java_shop.Cart.DTOs.InputBuyCartDTO;
import com.java_shop.Order.Order;
import com.java_shop.Order.OrderService;
import com.java_shop.Payment.Payment;
import com.java_shop.Payment.PaymentService;

import java.sql.SQLException;

public class CartService {
    /**
     * Покупка товаров и создание url для оплаты
     */
    public static String buy(InputBuyCartDTO inputBuyCartDTO) throws SQLException {
        // Создаем новый заказ
        // todo Нормально ли то что тут DTO из другого класса
        Order order = OrderService.add(inputBuyCartDTO);

        // Создаем новый платеж
        Payment payment = PaymentService.add(order);

        // Генерируем ссылку для оплаты на стороннем сервисе
        return PaymentService.generateURLforPay(payment.getId());
    }
}
