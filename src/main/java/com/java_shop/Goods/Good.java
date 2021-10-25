package com.java_shop.Goods;

import com.java_shop.Category.Category;

public class Good {
    private int id;
    private final String name;
    private final int price;
    private final Integer categoryId;
    private Category category;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

// Good под каждую категорию со своими полями
// Дополнительные поля описания можно делать через string:string