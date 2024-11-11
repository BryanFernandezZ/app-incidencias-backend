package com.app.gestion.app.repository;

import com.app.gestion.app.dto.ContratoDispositivoResponseDto;
import com.app.gestion.app.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContratoRepository extends JpaRepository<Contrato, Integer> {

    @Query("SELECT new com.app.gestion.app.dto.ContratoDispositivoResponseDto(c.idContrato, " +
            "UPPER(CONCAT(d.nombreCorto, ' de ', c.ubicacionReferencial)), c.ubicacionReferencial) " +
            "FROM Contrato c " +
            "INNER JOIN c.dispositivo d " +
            "WHERE c.cliente.idCliente = :id")
    List<ContratoDispositivoResponseDto> obtenerContratosCliente(@Param("id") Integer idCliente);

}
