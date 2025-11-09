package com.SpringFlix.SpringFlix.exception;

public class UsernameOrPasswordException extends RuntimeException {
    public UsernameOrPasswordException(String m){
        super(m);
    }
}
