package com.SpringFlix.SpringFlix.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="movie")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String description;
    private String image;
    private double rating;

    @Column(name= "release_date")
    private LocalDate releaseDate;

    @CreationTimestamp
    @Column(name= "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name= "updated_at")
    private LocalDateTime updatedAt;

    @ManyToMany
    @JoinTable(name = "movie_category",
    joinColumns = @JoinColumn(name="movie_id"),
    inverseJoinColumns =  @JoinColumn(name="category_id"))
    private List<CategoryModel> categories;

    @ManyToMany
    @JoinTable(name="movie_streaming",
    joinColumns = @JoinColumn(name = "movie_id"),
    inverseJoinColumns = @JoinColumn(name = "streaming_id"))
    private List<StreamingModel> streaming;
}


