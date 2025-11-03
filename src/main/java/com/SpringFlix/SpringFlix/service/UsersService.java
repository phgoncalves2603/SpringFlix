package com.SpringFlix.SpringFlix.service;

import com.SpringFlix.SpringFlix.model.UsersModel;
import com.SpringFlix.SpringFlix.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public UsersModel save(UsersModel usersModel){
        String password = usersModel.getPassword();
        usersModel.setPassword(passwordEncoder.encode(password)); //encoding password before save into db
        return  usersRepository.save(usersModel);
    }


}
