package com.app.gestion.app.repository;

import com.app.gestion.app.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

    Optional<Cliente> findByNombre(String nombre);

    @Query(value = "SELECT * FROM cliente  WHERE nombre=:nombre", nativeQuery = true)
    Optional<Cliente> filtrarNombre(@Param("nombre") String nombre);

//Optional<Cliente> findByNombre(String nombre);
}
