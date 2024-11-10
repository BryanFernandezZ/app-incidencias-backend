package com.app.gestion.app.service;

import com.app.gestion.app.model.Contrato;

import java.util.List;

public interface ContratoService {
    List<Contrato> obtenerContrato();
    Contrato verIdContrato(Integer idContrato);
    void guardarContrato(Contrato contrato);
    void actualizarContrato(Contrato contrato);
    void eliminarContrato (Integer idContrato);

}
