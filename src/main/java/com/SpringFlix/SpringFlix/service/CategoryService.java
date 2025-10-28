package com.SpringFlix.SpringFlix.service;


import com.SpringFlix.SpringFlix.dto.CategoryDTO;
import com.SpringFlix.SpringFlix.model.CategoryModel;
import com.SpringFlix.SpringFlix.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    CategoryRepository categoryRepository;

    public List<CategoryModel> findAll(){
        return categoryRepository.findAll();
    }

    public Optional<CategoryModel> findById(Long id){
        return categoryRepository.findById(id);
    }

    public void save(CategoryModel categoryModel){
        categoryRepository.save(categoryModel);
    }

    public void delete(Long id){
        categoryRepository.deleteById(id);
    }
}
