package com.SpringFlix.SpringFlix.controller;

import com.SpringFlix.SpringFlix.dto.MovieDTO;
import com.SpringFlix.SpringFlix.mapper.MovieMapper;
import com.SpringFlix.SpringFlix.model.MovieModel;
import com.SpringFlix.SpringFlix.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/SpringFlix/movie")
@RequiredArgsConstructor
public class MovieController {
    final MovieService service;

    @GetMapping()
    public ResponseEntity<List<MovieDTO>> findAll(){
        List<MovieModel> movieModels = service.findAll();
        return ResponseEntity.ok(movieModels.stream()
                        .map(MovieMapper::map)
                        .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Optional<MovieModel> movieModel=  service.findById(id);
        if(movieModel.isPresent()){
            return ResponseEntity.ok(MovieMapper.map(movieModel.get()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Movie id: "+id+" Was not found");

    }

    @PostMapping()
    public ResponseEntity<String> add(@RequestBody MovieDTO movieDTO){
        service.save(MovieMapper.map(movieDTO));
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Movie Created Successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if(service.findById(id).isPresent()){
            service.delete(id);
            return ResponseEntity.ok("Movie id: "+id+" deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Movie id: "+id+" Was not found");

    }
    @PutMapping
    public ResponseEntity<MovieDTO> update(@RequestBody MovieDTO updatedMovie){
        Optional<MovieModel> updated = service.update(MovieMapper.map(updatedMovie));
        if(updated.isPresent()){
            return ResponseEntity.ok(MovieMapper.map(updated.get()));
        }
        return ResponseEntity.notFound().build();
    }


}
