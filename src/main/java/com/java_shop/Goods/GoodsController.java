package com.java_shop.Goods;

import com.java_shop.Goods.DTOs.InputAddGoodDTO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Good> create(@RequestBody InputAddGoodDTO inputAddGoodDTO) {
        /// Проводим валидацию полей и передаем далее в GoodsService
        // GoodsController.isCreateGoodValid(InputCreateGoodDTO inputCreateGoodDTO);

        // если хотим отдать на фронт объект отличный от Good то создаем через OutputCreateGoodDTO
        // return new OutputCreateGoodDTO(good.getName(), good.getPrice());

        Good good = GoodsService.add(inputAddGoodDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(good.getId())
                .toUri();

        return ResponseEntity.created(uri).body(good);
    }

    // или вынести сразу валидацию в какой-нибудь GoodsValidation ?
    private boolean isCreateGoodValid(InputAddGoodDTO inputAddGoodDTO) {
        return true;
    }
}
