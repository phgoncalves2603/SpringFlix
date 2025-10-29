package com.SpringFlix.SpringFlix.service;

import com.SpringFlix.SpringFlix.model.MovieModel;
import com.SpringFlix.SpringFlix.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {
    final MovieRepository repository;

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
}
