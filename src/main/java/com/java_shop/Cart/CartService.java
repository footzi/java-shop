package com.java_shop.Cart;

import com.java_shop.Cart.DTOs.InputBuyCartDTO;
import com.java_shop.Client.ClientService;
import com.java_shop.Order.OrderService;
import com.java_shop.Payment.Payment;
import com.java_shop.Payment.PaymentService;

import java.sql.SQLException;

public class CartService {
    public static void buy(InputBuyCartDTO inputBuyCartDTO) throws Exception {
//        int clientId = inputBuyCartDTO.getClientId();
//        CartValues cartValues = inputBuyCartDTO
        // Создаем новый заказ
        OrderService.add(inputBuyCartDTO);

        // Создаем новый платеж
//        PaymentService.add(inputBuyCartDTO);

//        inputBuyCartDTO.getValues().forEach(cartValues -> System.out.println(cartValues.getCount()));
    }
}
