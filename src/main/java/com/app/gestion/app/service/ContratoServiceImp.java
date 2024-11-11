package com.app.gestion.app.service;

import com.app.gestion.app.dto.ContratoDispositivoResponseDto;
import com.app.gestion.app.model.Contrato;
import com.app.gestion.app.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContratoServiceImp implements ContratoService{

    @Autowired
    private ContratoRepository repository;

    @Override
    public List<Contrato> obtenerContrato() {
        return repository.findAll();
    }

    @Override
    public Contrato verIdContrato(Integer idContrato) {
        return repository.findById(idContrato).orElse(null);
    }

    @Override
    public void guardarContrato(Contrato contrato) {
        repository.save(contrato);

    }

    @Override
    public void actualizarContrato(Contrato contrato) {
        repository.saveAndFlush(contrato);

    }

    @Override
    public void eliminarContrato(Integer idContrato) {
        repository.deleteById(idContrato);

    }

    @Override
    public List<ContratoDispositivoResponseDto> obtenerContratosCliente(Integer idContrato) {
        return repository.obtenerContratosCliente(idContrato);
    }
}
