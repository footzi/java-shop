package com.java_shop.Category;

import com.java_shop.Category.DTOs.InputAddCategoryDTO;
import com.java_shop.Category.DTOs.OutputGetAllCategoriesDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    /**
     * Добавляет новую категорию
     */
    public static Category add(InputAddCategoryDTO inputAddCategoryDTO) throws SQLException  {
        // todo нужна валидация на существование parentId в БД
        Category category = new Category(0, inputAddCategoryDTO.getName(), inputAddCategoryDTO.getParentId());

        return CategoryRepository.add(category);
    }

    /**
     * Получение всего списка категорий
     */
    public static void getAll() throws SQLException {
        List<Category> categories = CategoryRepository.getAll();
        List<OutputGetAllCategoriesDTO> outputCategories = new ArrayList<>();

        for(Category category: categories) {
            int id = category.getId();
            String name = category.getName();
            Integer parentId = category.getParentId();

        }



        System.out.println(CategoryRepository.getAll());
    }
}
