package com.SpringFlix.SpringFlix.dto;

import com.SpringFlix.SpringFlix.model.MovieModel;

public class MovieMapper {
    public MovieDTO map(MovieModel movieModel){
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movieDTO.getId());
        movieDTO.setTitle(movieModel.getTitle());
        movieDTO.setSynoposys(movieModel.getSynopsys());
        movieDTO.setImage(movieModel.getImage());
        movieDTO.setReleaseDate(movieModel.getReleaseDate());
        movieDTO.setMovieCategory(movieModel.getMovieCategory());
        return movieDTO;
    }
    public MovieModel map(MovieDTO movieDTO){
        MovieModel movieModel = new MovieModel();
        movieModel.setId(movieDTO.getId());
        movieModel.setTitle(movieDTO.getTitle());
        movieModel.setSynopsys(movieDTO.getSynoposys());
        movieModel.setImage(movieDTO.getImage());
        movieModel.setReleaseDate(movieDTO.getReleaseDate());
        movieModel.setMovieCategory(movieDTO.getMovieCategory());
        return movieModel;
    }

}
