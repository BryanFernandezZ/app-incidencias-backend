package com.app.gestion.app.Security;

import com.app.gestion.app.model.Cuenta;
import com.app.gestion.app.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private CuentaRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cuenta cuenta = repository.findByNombreUsuario(username).orElseThrow(()->
                new UsernameNotFoundException("El usuario no existe"));
        return new User(cuenta.getNombreUsuario(),cuenta.getContrasena(), Collections.emptyList());
    }
}
