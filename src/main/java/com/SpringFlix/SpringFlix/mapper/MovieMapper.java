package com.SpringFlix.SpringFlix.mapper;

import com.SpringFlix.SpringFlix.dto.MovieDTO;
import com.SpringFlix.SpringFlix.model.MovieModel;

public class MovieMapper {
    public static MovieDTO map(MovieModel movieModel){
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movieDTO.getId());
        movieDTO.setTitle(movieModel.getTitle());
        movieDTO.setDescription(movieModel.getDescription());
        movieDTO.setImage(movieModel.getImage());
        movieDTO.setRating(movieModel.getRating());
        movieDTO.setReleaseDate(movieModel.getReleaseDate());
        movieDTO.setCreatedAt(movieModel.getCreatedAt());
        movieDTO.setUpdatedAt(movieModel.getUpdatedAt());
        return movieDTO;
    }
    public static MovieModel map(MovieDTO movieDTO){
        MovieModel movieModel = new MovieModel();
        movieModel.setId(movieDTO.getId());
        movieModel.setTitle(movieDTO.getTitle());
        movieModel.setDescription(movieDTO.getDescription());
        movieModel.setImage(movieDTO.getImage());
        movieModel.setRating(movieDTO.getRating());
        movieModel.setReleaseDate(movieDTO.getReleaseDate());
        movieModel.setCreatedAt(movieDTO.getCreatedAt());
        movieModel.setUpdatedAt(movieDTO.getUpdatedAt());


        return movieModel;
    }

}
