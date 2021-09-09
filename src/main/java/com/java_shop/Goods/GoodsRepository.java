package com.java_shop.Goods;

import com.java_shop.DbConnection;

// Должен оперировать только коллекциями? и где писать sql запросы?
// get /add /update /remove
public class GoodsRepository {
    public static Good add(Good good) {
        String query = "INSERT INTO goods (name, price) VALUES (" + "'" + good.getName() + "', " + good.getPrice() + ")";

        DbConnection.executeUpdate(query);



        return good;

        // Как потом получить данные в ответе от бэка?
    }

    // что делать если нам нужен другой запрос? использовать спецификацию?
    // https://habr.com/ru/post/263033/
    //List query(AccountSpecification specification);
}
