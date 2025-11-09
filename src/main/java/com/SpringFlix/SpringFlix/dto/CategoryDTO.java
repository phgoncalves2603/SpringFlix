package com.SpringFlix.SpringFlix.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryDTO {
    private Long id;
    @NotEmpty(message = "Category is needed")
    private String name;
}
