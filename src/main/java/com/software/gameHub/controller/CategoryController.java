package com.software.gameHub.controller;
import com.software.gameHub.entity.dto.CategoryDto;
import com.software.gameHub.entity.dto.CreateCategoryRequest;

import com.software.gameHub.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryDto> create(@Valid @RequestBody CreateCategoryRequest request) {

       return new ResponseEntity<>((categoryService.create(request)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll() {
        return new ResponseEntity<>(categoryService.findAll(),HttpStatus.OK);
    }

    @DeleteMapping("/categoryId")
    public ResponseEntity<Void> delete(@RequestParam int categoryId) {
        categoryService.delete(categoryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
