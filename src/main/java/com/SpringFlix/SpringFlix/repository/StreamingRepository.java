package com.SpringFlix.SpringFlix.repository;

import com.SpringFlix.SpringFlix.model.StreamingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamingRepository extends JpaRepository<StreamingModel,Long> {
}
