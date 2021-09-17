package com.java_shop.Cart;

import com.java_shop.Cart.DTOs.InputBuyCartDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
    public String buy(@RequestBody InputBuyCartDTO inputBuyCartDTO) {
        System.out.println(inputBuyCartDTO.getClient().getName());
        System.out.println(inputBuyCartDTO.getValues());

        return "12345";
    }
}
