package com.app.gestion.app.repository;

import com.app.gestion.app.model.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DispositivoRepository extends JpaRepository<Dispositivo, Integer> {

    @Query(value = "select d.id_dispositivo, d.nombre_corto, UPPER(CONCAT(d.nombre_corto, ' de ', c.ubicacion_referencial)) as nombre from dispositivo d \n" +
            "inner join contrato c on (c.id_dispositivo = d.id_dispositivo)\n" +
            "where c.id_cliente  = :id", nativeQuery = true)
    List<Dispositivo> obtenerDispositivosCliente(@Param("id") Integer idCliente);
}
