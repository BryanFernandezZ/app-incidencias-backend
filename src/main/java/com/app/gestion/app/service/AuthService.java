package com.app.gestion.app.service;

import com.app.gestion.app.dto.LoginRequestDTO;
import com.app.gestion.app.dto.LoginResponseDTO;
import com.app.gestion.app.model.Cuenta;

public interface AuthService {

    LoginResponseDTO login(LoginRequestDTO loginRequestDTO);
    Cuenta obtenerUsuario(String token);
}
