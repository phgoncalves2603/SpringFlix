package com.SpringFlix.SpringFlix.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    private long id;
    @NotEmpty(message = "Movie name is needed")
    private String title;
    private String description;
    private String image;
    private double rating;
    private LocalDate releaseDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
