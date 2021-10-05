package com.java_shop.Category.DTOs;

public class OutputGetAllCategoriesDTO {
    int id;
    String name;
    OutputGetAllCategoriesDTO parent;

    public OutputGetAllCategoriesDTO(int id, String name, OutputGetAllCategoriesDTO parent) {
        this.id = id;
        this.name = name;
        this.parent = parent;
    }
}
