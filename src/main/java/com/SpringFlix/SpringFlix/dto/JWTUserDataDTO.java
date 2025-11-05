package com.SpringFlix.SpringFlix.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JWTUserDataDTO {
    private Long id;
    private String name;
    private String email;
}
