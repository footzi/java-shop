package com.java_shop.Order;

import com.java_shop.Cart.DTOs.InputBuyCartDTO;

public class OrderService {
    // Плохо ли то что тут DTO из другого класса?
    public static Order add(InputBuyCartDTO inputBuyCartDTO) throws Exception {
        Order order = new Order(0, inputBuyCartDTO.getClientId(), 1000, inputBuyCartDTO.getValues(), OrderStatus.CREATED);

        return OrderRepository.add(order);
    }
}
