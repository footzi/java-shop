package com.java_shop.Goods;

import com.java_shop.Goods.DTOs.InputAddGoodDTO;

import java.sql.SQLException;

public class GoodsService {
    public static Good add(InputAddGoodDTO inputAddGoodDTO) throws Exception {
        Good good = new Good(0, inputAddGoodDTO.getName(), inputAddGoodDTO.getPrice());

        return GoodsRepository.add(good);
    }

    public static Good getById(int id) throws SQLException {
        return GoodsRepository.getById(id);
    }
}
