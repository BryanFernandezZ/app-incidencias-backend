package com.app.gestion.app.dto;

import com.app.gestion.app.model.Cliente;
import com.app.gestion.app.model.Dispositivo;
import com.app.gestion.app.model.Incidencia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContratoDispositivoResponseDto {
    private Integer idContrato;

    private String nombre;

    private String ubicacionReferencial;
}
