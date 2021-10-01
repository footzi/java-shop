package com.java_shop.Cart;

import com.java_shop.Cart.DTOs.InputBuyCartDTO;
import com.java_shop.Client.Client;
import com.java_shop.Response.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/cart")
public class CartController {

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> buy(@RequestBody InputBuyCartDTO inputBuyCartDTO) {
        try {
            String url = CartService.buy(inputBuyCartDTO);

            Response<String> response = new Response<>(url);

            return ResponseEntity.ok(response.getBody());
        } catch (SQLException error) {
            Response<String> response = new Response<>("", error.getMessage());
            return ResponseEntity.internalServerError().body(response.getBody());
        }
    }
}
