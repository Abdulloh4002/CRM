package org.example.marketapplication.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.marketapplication.dto.CategoryDTO;
import org.example.marketapplication.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
@RequiredArgsConstructor
public class CategoryController {


    private final CategoryService service;

    @GetMapping
    public List<CategoryDTO> getAllCategories(){
        return service.getAllCategories();
    }

    @GetMapping("{id}")
    public CategoryDTO getCategory(@PathVariable Integer id){

        return service.getCategoryById(id);
    }

    @PostMapping
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO){

        return service.createCategory(categoryDTO);
    }

    @PutMapping("{id}")
    public CategoryDTO updateCategory(@PathVariable Integer id, @RequestBody CategoryDTO categoryDTO ){

        return service.updateCategory(id, categoryDTO);

    }

    @DeleteMapping("{id}")
    public void deleteCategory(@PathVariable Integer id){

        service.deleteCategory(id);
    }
}
