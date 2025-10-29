package com.SpringFlix.SpringFlix.repository;

import com.SpringFlix.SpringFlix.model.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieModel,Long> {
}
