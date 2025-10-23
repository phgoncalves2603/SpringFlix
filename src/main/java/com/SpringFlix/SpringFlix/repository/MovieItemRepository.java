package com.SpringFlix.SpringFlix.repository;

import com.SpringFlix.SpringFlix.model.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieItemRepository extends JpaRepository<MovieModel,Long> {
}
