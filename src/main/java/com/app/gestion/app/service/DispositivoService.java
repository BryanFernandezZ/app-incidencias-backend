package com.app.gestion.app.service;

import com.app.gestion.app.model.Dispositivo;

import java.util.List;

public interface DispositivoService {

    List<Dispositivo> obtenerDispositivosCliente(Integer idCliente);
}
