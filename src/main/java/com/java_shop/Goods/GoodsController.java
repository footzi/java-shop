package com.java_shop.Goods;

import com.java_shop.Goods.DTOs.InputAddGoodDTO;
import com.java_shop.Helpers.Helpers;
import com.java_shop.Response.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.sql.SQLException;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> add(@RequestBody InputAddGoodDTO inputAddGoodDTO) {
        try {
            /// Проводим валидацию полей и передаем далее в GoodsService
            // GoodsController.isCreateGoodValid(InputCreateGoodDTO inputCreateGoodDTO);

            // если хотим отдать на фронт объект отличный от Good то создаем через OutputCreateGoodDTO
            // return new OutputCreateGoodDTO(good.getName(), good.getPrice());

            Good good = GoodsService.add(inputAddGoodDTO);
            URI uri = Helpers.createUri(good.getId());

            Response<Good> response = new Response<>(good);

            return ResponseEntity.created(uri).body(response.getBody());
        } catch (Exception error) {
            Response<String> response = new Response<>("", error.getMessage());
            return ResponseEntity.internalServerError().body(response.getBody());
        }
    }
}
