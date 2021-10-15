package com.java_shop.Goods;

public class Good {
    private int id;
    private final String name;
    private final int price;
    private final Integer categoryId;

    public Good(int id, String name, int price, Integer categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }
}

// Good под каждую категорию со своими полями
// Дополнительные поля описания можно делать через string:string