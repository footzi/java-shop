package com.java_shop.Goods;

import com.java_shop.Goods.DTOs.InputAddGoodDTO;

public class GoodsService {
    public static Good add(InputAddGoodDTO inputAddGoodDTO) {
        Good good = new Good(0, inputAddGoodDTO.getName(), inputAddGoodDTO.getPrice());

        return GoodsRepository.add(good);
    }
}
