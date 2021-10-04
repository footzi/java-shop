package com.java_shop.Payment;

import com.java_shop.Order.Order;
import com.java_shop.Order.OrderService;

import java.sql.SQLException;

public class PaymentService {
    /**
     * Создание нового платежа
     */
    public static Payment add(Order order) throws SQLException {
        Payment payment = new Payment(0, order.getId(), order.getSum(), PaymentStatus.NOT_PAID);

        return PaymentRepository.add(payment);
    }

    /**
     * Получение платежа по Id
     */
    public static Payment getById(int paymentId) throws SQLException {
        return PaymentRepository.getById(paymentId);
    }

    /**
     * Генерация ссылки для оплаты на стороннем сервисе
     */
    public static String generateURLforPay(int paymentId) {
        return "/yandex-kassa?paymentId=" + paymentId;
    }

    /**
     * Коллбэк на успешную оплату товара и передача по следующим этапам
     */
    public static boolean success(int paymentId) throws SQLException {
        Payment payment = PaymentRepository.getById(paymentId);

        boolean isChangeOrderStatus = OrderService.setPayStatus(payment.getOrderId());

        return isChangeOrderStatus && PaymentService.setPayStatus(paymentId);
    }

    /**
     * Установка статуса "Оплачено"
     */
    public static boolean setPayStatus(int paymentId) throws SQLException {
        return PaymentRepository.changeStatus(paymentId, PaymentStatus.PAID);
    }
}