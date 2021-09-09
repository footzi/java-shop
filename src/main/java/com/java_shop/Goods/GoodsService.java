package com.java_shop.Goods;

import static com.java_shop.Goods.GoodsRepository.*;

// String name, int price
public class GoodsService {
    public static void saveGood() {
        GoodsRepository.saveGood("hello", 100);
    }
}
