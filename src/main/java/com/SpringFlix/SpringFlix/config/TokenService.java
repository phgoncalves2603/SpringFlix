package com.SpringFlix.SpringFlix.config;


import com.SpringFlix.SpringFlix.dto.JWTUserDataDTO;
import com.SpringFlix.SpringFlix.model.UsersModel;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Base64;
import java.util.Optional;

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

    public Optional<JWTUserDataDTO> verifyToken(String token){
        Algorithm algorithm = Algorithm.HMAC256(secret);

        DecodedJWT jwt = JWT.require(algorithm)
                .build()
                .verify(token);
        JWTUserDataDTO jwtUserDataDTO = new JWTUserDataDTO();
        jwtUserDataDTO.setId(jwt.getClaim("userId").asLong());
        jwtUserDataDTO.setName(jwt.getClaim("name").asString());
        jwtUserDataDTO.setEmail(jwt.getSubject());

        return Optional.of(jwtUserDataDTO);
    }

}
