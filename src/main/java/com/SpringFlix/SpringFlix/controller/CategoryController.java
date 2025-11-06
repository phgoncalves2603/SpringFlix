package com.SpringFlix.SpringFlix.controller;


import com.SpringFlix.SpringFlix.dto.CategoryDTO;
import com.SpringFlix.SpringFlix.mapper.CategoryMapper;
import com.SpringFlix.SpringFlix.model.CategoryModel;
import com.SpringFlix.SpringFlix.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor // Lombok insure the dependency injection will happen
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping()
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        List <CategoryModel> categories = categoryService.findAll();
        return ResponseEntity.ok(categories.stream()
                .map(CategoryMapper::map)
                .toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id){
        Optional<CategoryModel> category = categoryService.findById(id);
        if (category.isPresent()){
            return ResponseEntity.ok(CategoryMapper.map(category.get())); //apparently can use lambda to do this "category.ifPresent(ResponseEntity::ok);" but i like the if more
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Category id:"+id+" Not Found");
        }
    }
    @PostMapping()
    public ResponseEntity<String> addCategory(@RequestBody CategoryDTO categoryDTO){
        categoryService.save(CategoryMapper.map(categoryDTO));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Category Created Successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        if(categoryService.findById(id).isPresent()){
            categoryService.delete(id);
            return ResponseEntity.ok("Category with id: "+id+" was deleted");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Category with id: "+id+" Not Found");
    }

}
