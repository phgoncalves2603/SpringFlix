package com.SpringFlix.SpringFlix.model;

import com.SpringFlix.SpringFlix.enums.MovieCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="Movie_Item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String synopsys;
    private String image;
    private LocalDate releaseDate;
    private MovieCategory movieCategory;
}
