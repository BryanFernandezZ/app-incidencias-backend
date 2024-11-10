package com.app.gestion.app.controller;


import com.app.gestion.app.Security.UserDetailService;
import com.app.gestion.app.Security.jwt.JwtAuthenticationProvider;
import com.app.gestion.app.dto.LoginRequestDTO;
import com.app.gestion.app.dto.LoginResponseDTO;
import com.app.gestion.app.model.Cuenta;
import com.app.gestion.app.repository.CuentaRepository;
import com.app.gestion.app.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Tag(name = "AuthController")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST, consumes = {APPLICATION_JSON_VALUE},
            produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        LoginResponseDTO loginResponseDto = authService.login(loginRequestDTO);
        return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
    }


    @RequestMapping(path = "/obtenerUsuario", method = RequestMethod.GET, produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<?> obtenerUsuario(@RequestParam(value = "token", defaultValue = "", required = true) String token) {
        Cuenta cuenta = authService.obtenerUsuario(token);
        return new ResponseEntity<>(cuenta, HttpStatus.OK);
    }
}
