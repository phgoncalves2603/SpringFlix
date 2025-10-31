package com.SpringFlix.SpringFlix.repository;

import com.SpringFlix.SpringFlix.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UsersModel,Long> {
}
