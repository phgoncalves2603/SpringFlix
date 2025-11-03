package com.SpringFlix.SpringFlix.config;


import com.SpringFlix.SpringFlix.model.UsersModel;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TokenService {

    @Value("${springflix.security.secret}")
    private String secret;
    public String GenerateToken(UsersModel user) {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withSubject(user.getEmail())
                .withClaim("userId",user.getId())
                .withClaim("name",user.getName())
                .withExpiresAt(Instant.now().plusSeconds(86400))
                .withIssuedAt(Instant.now())
                .withIssuer("API SpringFlix")
                .sign(algorithm);
    }

}
