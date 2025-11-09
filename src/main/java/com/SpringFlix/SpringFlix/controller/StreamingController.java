package com.SpringFlix.SpringFlix.controller;


import com.SpringFlix.SpringFlix.dto.StreamingDTO;
import com.SpringFlix.SpringFlix.mapper.StreamingMapper;
import com.SpringFlix.SpringFlix.model.StreamingModel;
import com.SpringFlix.SpringFlix.service.StreamingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/springFlix/streaming")
@RequiredArgsConstructor
public class StreamingController {
    final StreamingService service;

    @GetMapping()
    public ResponseEntity<List<StreamingDTO>> getAllStreaming(){
        List<StreamingModel> streaming = service.findAll();
        return ResponseEntity.ok(streaming.stream()
                .map(StreamingMapper::map)
                .toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Optional<StreamingModel> streaming = service.findById(id);
        if(streaming.isPresent()){
            return ResponseEntity.ok(StreamingMapper.map(streaming.get()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Streaming id: "+id+" Not Found");
    }
    @PostMapping
    public ResponseEntity<String> add(@Valid @RequestBody StreamingDTO streamingDTO){
        service.save(StreamingMapper.map(streamingDTO));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Streaming Created Successfully");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if(service.findById(id).isPresent()){
            service.delete(id);
            return  ResponseEntity.ok("Streaming id: "+id+" deleted");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Streaming id: "+id+" Not Found");
    }
}
