package com.SpringFlix.SpringFlix.mapper;

import com.SpringFlix.SpringFlix.dto.MovieDTO;
import com.SpringFlix.SpringFlix.model.MovieModel;

public class MovieMapper {
    public static MovieDTO map(MovieModel movieModel){
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movieDTO.getId());
        movieDTO.setTitle(movieModel.getTitle());
        movieDTO.setSynoposys(movieModel.getSynopsys());
        movieDTO.setImage(movieModel.getImage());
        movieDTO.setReleaseDate(movieModel.getReleaseDate());
        return movieDTO;
    }
    public static MovieModel map(MovieDTO movieDTO){
        MovieModel movieModel = new MovieModel();
        movieModel.setId(movieDTO.getId());
        movieModel.setTitle(movieDTO.getTitle());
        movieModel.setSynopsys(movieDTO.getSynoposys());
        movieModel.setImage(movieDTO.getImage());
        movieModel.setReleaseDate(movieDTO.getReleaseDate());
        return movieModel;
    }

}
