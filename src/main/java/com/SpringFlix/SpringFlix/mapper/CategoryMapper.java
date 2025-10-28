package com.SpringFlix.SpringFlix.mapper;

import com.SpringFlix.SpringFlix.dto.CategoryDTO;
import com.SpringFlix.SpringFlix.model.CategoryModel;

public class CategoryMapper {
    public static CategoryDTO map(CategoryModel categoryModel){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(categoryModel.getId());
        categoryDTO.setName(categoryModel.getName());
        return categoryDTO;
    }
    public static CategoryModel map(CategoryDTO categoryDTO){
        CategoryModel categoryModel = new CategoryModel();
        categoryModel.setId(categoryDTO.getId());
        categoryModel.setName(categoryDTO.getName());
        return categoryModel;
    }
}
