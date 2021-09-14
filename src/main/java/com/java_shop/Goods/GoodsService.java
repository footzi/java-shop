package com.java_shop.Goods;

import com.java_shop.Goods.DTOs.InputCreateGoodDTO;

// в сервисах видимо будет выполняться обращение к другим сервисам для агрегации данных
public class GoodsService {
    public static Good createGood(InputCreateGoodDTO inputCreateGoodDTO) {
        Good good = new Good(0, inputCreateGoodDTO.getName(), inputCreateGoodDTO.getPrice());

        return good;
    }

    public static Good saveGood(String name, int price) {

        // Тут ли должен создаваться объект Good и как сгенерить id?
        Good good = new Good(1, name, price);

        return GoodsRepository.add(good);
    }
}
