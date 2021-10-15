package com.java_shop.Category;

import com.java_shop.DbConnection.DBConnectionInput;
import com.java_shop.DbConnection.DbConnection;
import com.java_shop.DbConnection.DbConnectionResult;
import com.java_shop.DbConnection.DbConnectionResultList;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    /**
     * Добавляет новую категорию
     */
    public static Category add(Category category) throws SQLException {
        String values = "'" + category.getName() + "', " + category.getParentId();
        String query = "INSERT INTO categories (name, sub_categories_id) VALUES (" + values + ")";

        int newGoodId = DbConnection.executeUpdate(query);
        category.setId(newGoodId);

        return category;
    }

    /**
     * Получение всего списка категорий
     */
    public static List<Category> getAll() throws SQLException {
        String query = "SELECT * FROM categories";

        DBConnectionInput input = new DBConnectionInput()
                .addField("category_id", "int")
                .addField("name", "string")
                .addField("parent_id", "int");

        DbConnectionResultList resultList = DbConnection.executeQueryList(query, input);

        List<Category> categories = new ArrayList<>();

        for (DbConnectionResult result: resultList.getList()) {
            Category category = new Category(
                result.getFieldInt("category_id"),
                result.getFieldString("name"),
                result.getFieldInt("parent_id")
            );

            categories.add(category);
        }

        return categories;
    }
}
