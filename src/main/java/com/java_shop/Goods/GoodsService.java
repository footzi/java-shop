package com.java_shop.Goods;

import com.java_shop.Goods.DTOs.InputAddGoodDTO;

import java.sql.SQLException;
import java.util.List;

public class GoodsService {
    /**
     * Добавление нового товара
     */
    public static Good add(InputAddGoodDTO inputAddGoodDTO) throws SQLException {
        Good good = new Good(0, inputAddGoodDTO.getName(), inputAddGoodDTO.getPrice());

        return GoodsRepository.add(good);
    }

    /**
     * Поиск товара по ID
     */
    public static Good getById(int id) throws SQLException {
        return GoodsRepository.getById(id);
    }

    /**
     * Получение всего списка товаров
     */
    public static List<Good> getAll() throws SQLException {
        return GoodsRepository.getAll();
    }
}
