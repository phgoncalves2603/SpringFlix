package com.SpringFlix.SpringFlix.service;

import com.SpringFlix.SpringFlix.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {
    final private UsersRepository usersRepository;



}
