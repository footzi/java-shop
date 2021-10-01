package com.java_shop.Payment;

import com.java_shop.Order.Order;

import java.sql.SQLException;

public class PaymentService {
    /**
     * Создание нового платежа
     */
    public static Payment add(Order order) throws SQLException {
        Payment payment = new Payment(0, order.getClientId(), order.getSum(), PaymentStatus.NOT_PAID);

        return PaymentRepository.add(payment);
    }


    /**
     * Генерация ссылки для оплаты на стороннем сервисе
     */
    public static String generateURLforPay(int orderId) {
        return "/yandex-kassa?orderId=" + orderId;
    }

    /**
     * Коллбэк на успешную оплату товара и передача по следующим этапам
     */
    public static void success(int paymentId) throws SQLException{
        PaymentService.setPayStatus(paymentId);
    }

    /**
     * Установка статуса "Оплачено"
     */
    public static void setPayStatus(int paymentId) throws SQLException {
        PaymentRepository.changeStatus(paymentId, PaymentStatus.PAID);
    }
}