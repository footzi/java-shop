package com.java_shop.Category;

import com.java_shop.Category.DTOs.InputAddCategoryDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public static List<Category> getAll() throws SQLException {
        List<Category> categories = CategoryRepository.getAll();

        Map<Integer, List<Category>> groupedByParent = categories
                .stream()
                .collect(Collectors.groupingBy(category -> category.getParentId() == null ? 0 : category.getParentId()));

        List<Category> rootCategories = groupedByParent.get(0);
        rootCategories.forEach(category -> setSubCategory(category, groupedByParent));

        return rootCategories;
    }

    /**
     * Устанавливает подкатегории для категории
     */
    private static void setSubCategory(Category category, Map<Integer, List<Category>> groupedByParent) {
        List<Category> children = groupedByParent.get(category.getId());

        if (children != null) {
            category.setSubCategories(children);

            for (Category child : children) {
                setSubCategory(child, groupedByParent);
            }
        }
    }

    /**
     * Возвращает массив категорий для товара (Компьютеры -> Ноутбуки и планшеты -> Для дома и учебы)
     */
    public static void getCategories(int categoryId) throws SQLException {
        List<Category> allCategories = CategoryRepository.getAll();
        List<Category> categories = new ArrayList<>();

//        Category findedCategory = findCategory(allCategories, categoryId);
//
//        if (findedCategory != null) {
//            categories.add(findedCategory);
//        }

//        if (findedCategory.getParentId() != null) {
//
//        }


    }

    private static void set() {

    }


    private static void findCategory(List<Category> allCategories, int categoryId) {
//        Optional<Category> findedCaegory = allCategories.stream().filter(category -> category.getId() == categoryId).findAny();
//
//        if (findedCaegory.isPresent()) {
//            return findedCaegory;
//        } else {
//            return null;
//        }

//        return allCategories.stream().filter(category -> category.getId() == categoryId).findAny();
        // }
    }
}
