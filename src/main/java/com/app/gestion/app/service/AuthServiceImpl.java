package com.app.gestion.app.service;

import com.app.gestion.app.Security.UserDetailService;
import com.app.gestion.app.Security.jwt.JwtAuthenticationProvider;
import com.app.gestion.app.dto.LoginRequestDTO;
import com.app.gestion.app.dto.LoginResponseDTO;
import com.app.gestion.app.model.Cuenta;
import com.app.gestion.app.repository.CuentaRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtAuthenticationProvider jwtAuthenticationProvider;
    private final CuentaRepository cuentaRepository;
    private final UserDetailService userDetailService;

    public AuthServiceImpl(AuthenticationManager authenticationManager, JwtAuthenticationProvider jwtAuthenticationProvider, CuentaRepository cuentaRepository, UserDetailService userDetailService) {
        this.authenticationManager = authenticationManager;
        this.jwtAuthenticationProvider = jwtAuthenticationProvider;
        this.cuentaRepository = cuentaRepository;
        this.userDetailService = userDetailService;
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequestDTO.getUsername(), loginRequestDTO.getPassword()
        ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Cuenta cuenta = cuentaRepository.findByNombreUsuario(loginRequestDTO.getUsername()).orElseThrow(
                () -> new UsernameNotFoundException("Usuario no encontrado"));
        String token = jwtAuthenticationProvider.generarToken(authentication, cuenta);

        return LoginResponseDTO.builder()
                .tipoToken("Bearer")
                .token(token)
                .timestamp(LocalDateTime.now().toString())
                .build();
    }

    @Override
    public Cuenta obtenerUsuario(String token) {
        String username = jwtAuthenticationProvider.obtenerUsuarioDelJwt(token);
        return cuentaRepository.findByNombreUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Este usuario no existe"));
    }
}
