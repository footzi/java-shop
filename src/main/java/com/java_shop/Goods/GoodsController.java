package com.java_shop.Goods;

import com.java_shop.Goods.DTOs.OutputCreateGoodDTO;

public class GoodsController {
    public static OutputCreateGoodDTO saveGood(String data) {
        // разбираем data и получаем - String name, int price
        String name = "hello";
        int price = 10000;

        // DTO без конструктора с аргументами но с сеттерами
        // GoodCreate - сделать тут и передавать в GoodsService.saveGood
        /// тут надо сложить name и price в InputCreateGoodDTO ??
        Good good = GoodsService.saveGood(name, price);

        // если хотим отдать на фронт объект отличный от Good
        return new OutputCreateGoodDTO(good.getName(), good.getPrice());
    }
}
