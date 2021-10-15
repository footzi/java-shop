package com.java_shop.Category;

import java.util.List;

public class Category {
    private int id;
    private final String name;
    private final Integer parentId;
    private List<Category> subCategories;

    public Category(int id, String name, Integer parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public List<Category> getSubCategories() {
        return this.subCategories;
    }

    public String getName() {
        return this.name;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public void setSubCategories(List<Category> subCategories) {
        this.subCategories = subCategories;
    }
}
