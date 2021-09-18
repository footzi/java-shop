package com.java_shop.Goods;

public class Good implements IGood {
    int id;
    String name;
    int price;

    public Good(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}

// Good под каждую категорию со своими полями
// Дополнительные поля описания можно делать через string:string