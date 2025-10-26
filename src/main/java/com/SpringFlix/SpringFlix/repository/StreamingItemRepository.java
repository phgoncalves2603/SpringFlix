package com.SpringFlix.SpringFlix.repository;

import com.SpringFlix.SpringFlix.model.StreamingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamingItemRepository extends JpaRepository<StreamingModel,Long> {
}
