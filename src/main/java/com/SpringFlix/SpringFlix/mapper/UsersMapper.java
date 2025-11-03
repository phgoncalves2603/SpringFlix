package com.SpringFlix.SpringFlix.mapper;

import com.SpringFlix.SpringFlix.dto.UsersDTO;
import com.SpringFlix.SpringFlix.model.UsersModel;

public class UsersMapper {
    public static UsersDTO map(UsersModel usersModel){
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setId(usersModel.getId());
        usersDTO.setName(usersModel.getName());
        usersDTO.setEmail(usersModel.getEmail());
        usersDTO.setPassword(usersModel.getPassword());

        return usersDTO;
    }

    public static UsersModel map(UsersDTO usersDTO){
        UsersModel usersModel = new UsersModel();
        usersModel.setId(usersDTO.getId());
        usersModel.setName(usersDTO.getName());
        usersModel.setEmail(usersDTO.getEmail());
        usersModel.setPassword(usersDTO.getPassword());

        return usersModel;
    }
}
