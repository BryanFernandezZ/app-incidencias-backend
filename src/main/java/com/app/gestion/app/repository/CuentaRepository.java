package com.app.gestion.app.repository;

import com.app.gestion.app.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CuentaRepository extends JpaRepository<Cuenta,Integer> {

    Optional<Cuenta> findByNombreUsuario(String nombreUsuario);
}
