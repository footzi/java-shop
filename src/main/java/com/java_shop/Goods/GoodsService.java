package com.java_shop.Goods;

// в сервисах видимо будет выполняться обращение к другим сервисам для агрегации данных
public class GoodsService {
    public static Good saveGood(String name, int price) {

        // Тут ли должен создаваться объект Good и как сгенерить id?
        Good good = new Good(1, name, price);

        return GoodsRepository.add(good);
    }
}
