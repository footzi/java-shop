package com.java_shop.Goods;

import com.java_shop.Goods.DTOs.OutputCreateGoodDTO;
import com.java_shop.Goods.DTOs.InputCreateGoodDTO;

public class GoodsController {
    public static Good createGood(InputCreateGoodDTO inputCreateGoodDTO) {
        /// Проводим валидацию полей и передаем далее в GoodsService
        // GoodsController.isCreateGoodValid(InputCreateGoodDTO inputCreateGoodDTO);

        return GoodsService.createGood(inputCreateGoodDTO);
        // если хотим отдать на фронт объект отличный от Good то создаем через OutputCreateGoodDTO
        // return new OutputCreateGoodDTO(good.getName(), good.getPrice());
    }

    // или вынести сразу валидацию в какой-нибудь GoodsValidation ?
    private boolean isCreateGoodValid(InputCreateGoodDTO inputCreateGoodDTO) {
        return true;
    }

    public static String saveGood(String data) {
        // разбираем data и получаем - String name, int price
        String name = "hello";
        int price = 10000;

        /// тут надо сложить name и price в InputCreateGoodDTO ??
//        Good good = GoodsService.saveGood(name, price);

//        Good good = new Good(1, "wewe", 1111);

        return "3333";
        // если хотим отдать на фронт объект отличный от Good
//        return good;
//        return new OutputCreateGoodDTO(good.getName(), good.getPrice());
    }
}
