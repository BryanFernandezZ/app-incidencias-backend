package com.app.gestion.app.dto;

import com.app.gestion.app.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequestDto {
    private Integer idCliente;

    public Cliente mapToEntidad() {
        return new Cliente(this.idCliente);
    }
}
