package com.app.gestion.app.service;

import com.app.gestion.app.model.Dispositivo;
import com.app.gestion.app.repository.DispositivoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispositivoServiceImpl implements DispositivoService {

    private final DispositivoRepository repository;

    public DispositivoServiceImpl(DispositivoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Dispositivo> obtenerDispositivosCliente(Integer idCliente) {
        return repository.obtenerDispositivosCliente(idCliente);
    }
}
