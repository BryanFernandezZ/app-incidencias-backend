package com.app.gestion.app.dto;

import com.app.gestion.app.model.Contrato;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratoRequestDto {
    private Integer idContrato;

    public Contrato mapToEntidad() {
        return new Contrato(this.idContrato);
    }
}
