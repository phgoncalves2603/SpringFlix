package com.SpringFlix.SpringFlix.service;

import com.SpringFlix.SpringFlix.model.CategoryModel;
import com.SpringFlix.SpringFlix.model.MovieModel;
import com.SpringFlix.SpringFlix.model.StreamingModel;
import com.SpringFlix.SpringFlix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository repository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;

    public List<MovieModel> findAll(){
        return repository.findAll();
    }

    public Optional<MovieModel> findById(Long id){
        return repository.findById(id);
    }

    public void save(MovieModel movieModel){
        repository.save(movieModel);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
    public Optional<MovieModel> update(MovieModel updatedMovie){
        Optional<MovieModel> optMovie = repository.findById(updatedMovie.getId());
        if (optMovie.isPresent()){
            MovieModel movie = optMovie.get();
            movie.setTitle(updatedMovie.getTitle());
            movie.setDescription(updatedMovie.getDescription());
            movie.setRating(updatedMovie.getRating());
            movie.setReleaseDate(updatedMovie.getReleaseDate());
            movie.setImage(updatedMovie.getImage());

            movie.getCategories().clear();
            movie.getCategories().addAll(findCategories(updatedMovie.getCategories()));

            movie.getStreaming().clear();
            movie.getStreaming().addAll(findStreaming(updatedMovie.getStreaming()));

            return Optional.of(movie);
        }
        return Optional.empty();
    }

    public List<CategoryModel> findCategories(List<CategoryModel> categories){
        List<CategoryModel> categoryList = new ArrayList<>();
        categories.forEach(category -> {
            Optional<CategoryModel> optCategory = categoryService.findById(category.getId());
            optCategory.ifPresent(categoryList::add);
        });
        return categoryList;
    }

    public List<StreamingModel> findStreaming(List<StreamingModel> streamingServices){
        List<StreamingModel> streamingList = new ArrayList<>();
        streamingServices.forEach(streaming -> {
            Optional<StreamingModel> optStreaming = streamingService.findById(streaming.getId());
            optStreaming.ifPresent(streamingList::add);
        });
        return streamingList;
    }



}
