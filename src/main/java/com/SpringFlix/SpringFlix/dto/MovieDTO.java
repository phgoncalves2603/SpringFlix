package com.SpringFlix.SpringFlix.dto;

import com.SpringFlix.SpringFlix.enums.MovieCategory;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    private long id;
    private String title;
    private String synoposys;
    private String image;
    private LocalDate releaseDate;
    private MovieCategory movieCategory;
}
