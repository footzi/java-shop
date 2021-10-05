package com.java_shop.Category;

import com.java_shop.Category.DTOs.InputAddCategoryDTO;
import com.java_shop.Helpers.Helpers;
import com.java_shop.Response.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> add(@RequestBody InputAddCategoryDTO inputAddCategoryDTO) {
        try {
            Category category = CategoryService.add(inputAddCategoryDTO);

            Response<Category> response = new Response<>(category);
            URI uri = Helpers.createUri(category.getId());

            return ResponseEntity.created(uri).body(response.getBody());
        } catch (SQLException error) {

            Response<String> response = new Response<>("", error.getMessage());
            return ResponseEntity.internalServerError().body(response.getBody());
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAll() {
        try {
            CategoryService.getAll();
//            List<Good> goods = GoodsService.getAll();
//            Response<List<Good>> response = new Response<>(goods);

            return ResponseEntity.ok("response.getBody()");
        } catch (SQLException error) {
            Response<String> response = new Response<>("", error.getMessage());
            return ResponseEntity.internalServerError().body(response.getBody());
        }
    }
}
