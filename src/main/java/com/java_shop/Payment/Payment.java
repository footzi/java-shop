package com.java_shop.Payment;

public class Payment {
    int id;
    int orderId;
    int sum;
    PaymentStatus status;

    Payment(int id, int orderId, int sum, PaymentStatus status) {
        this.id = id;
        this.orderId = orderId;
        this.sum = sum;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSum() {
        return sum;
    }

    public PaymentStatus getStatus() {
        return status;
    }
}
