package com.SpringFlix.SpringFlix.service;

import com.SpringFlix.SpringFlix.model.StreamingModel;
import com.SpringFlix.SpringFlix.repository.StreamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class StreamingService {
    final StreamingRepository repository;

    public List<StreamingModel> findAll(){
        return repository.findAll();
    }

    public Optional<StreamingModel> findById(Long id){
        return repository.findById(id);
    }

    public void save(StreamingModel streamingModel){
        repository.save(streamingModel);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
