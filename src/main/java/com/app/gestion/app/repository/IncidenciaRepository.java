package com.app.gestion.app.repository;

import com.app.gestion.app.model.Incidencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidenciaRepository extends JpaRepository<Incidencia, Integer> {
}
