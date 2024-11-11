package com.app.gestion.app.dto;

import com.app.gestion.app.model.Incidencia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IncidenciaRequestDto {
    private String asunto;
    private String detalle;
    private String nomDispo;
    private Integer calificacion;
    private Boolean pendiente;
    private Boolean presencial;
    private Boolean solucionado;
    private Integer usuarioAsignado;
    private ClienteRequestDto cliente;
    private ContratoRequestDto contrato;

    public Incidencia toEntidad() {
        return new Incidencia(
                this.asunto,
                this.detalle,
                this.calificacion,
                this.pendiente,
                this.presencial,
                this.solucionado,
                this.usuarioAsignado,
                this.cliente.mapToEntidad(),
                this.contrato.mapToEntidad()
        );
    }

}
