package com.java_shop.Goods;

import com.google.gson.Gson;

import java.util.List;

public class GoodsController {
    public String getGoodById(String id) {
        GoodsData goodsData = new GoodsData();
        Good good = goodsData.getGoodById(id);

        Gson gson = new Gson();
        return gson.toJson(good);
    }

    /**
     * Возможно в контроллере нужно разбирать сырые данные и прокидывать их в модель, а та в свою очередь будет сохранять их в ДАТА
     */

    // String name, int price
    public static void saveGood() {
        GoodsService.saveGood();
//        GoodsData goodsData = new GoodsData();
//
//        int lastId = goodsData.getLastGoodId();
//        Good good = new Good(lastId, name, price);
//
//        goodsData.saveGood(good);
    }

    public String getAllGoods() {
        GoodsData goodsData = new GoodsData();
        List<Good> allGoods = goodsData.getAllGoods();

        Gson gson = new Gson();
        return gson.toJson(allGoods);
    }
}