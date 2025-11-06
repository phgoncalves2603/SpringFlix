package com.SpringFlix.SpringFlix.controller;


import com.SpringFlix.SpringFlix.config.TokenService;
import com.SpringFlix.SpringFlix.dto.LoginDTO;
import com.SpringFlix.SpringFlix.dto.TokenDTO;
import com.SpringFlix.SpringFlix.dto.UsersDTO;
import com.SpringFlix.SpringFlix.mapper.UsersMapper;
import com.SpringFlix.SpringFlix.model.UsersModel;
import com.SpringFlix.SpringFlix.service.UsersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UsersService usersService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    

    @PostMapping("/register")
    public ResponseEntity<UsersDTO> save(@RequestBody UsersDTO usersDTO){
        usersService.save(UsersMapper.map(usersDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(usersDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login(@RequestBody LoginDTO request) {
            try {
                UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
                Authentication authenticate = authenticationManager.authenticate(userAndPass);

                UsersModel user = (UsersModel) authenticate.getPrincipal();

                String token = tokenService.GenerateToken(user);

                TokenDTO t = new TokenDTO(token);
                System.out.println(token);
                return ResponseEntity.ok().body(t);
            }catch (Exception e){
                System.out.println(e.getMessage()+"\n"+e.getCause());

            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new TokenDTO(""));

    }


}
