package com.java_shop;

import com.java_shop.Goods.DTOs.InputCreateGoodDTO;
import com.java_shop.Goods.GoodsController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @PostMapping(path="/goods", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
    public String createGood(@ModelAttribute InputCreateGoodDTO inputCreateGoodDTO) {
        return toString();
    }

}
