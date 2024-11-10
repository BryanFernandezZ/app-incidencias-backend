package com.app.gestion.app.service;

import com.app.gestion.app.model.Incidencia;
import com.app.gestion.app.repository.IncidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidenciaServiceImp implements IncidenciaService{

    @Autowired
    private IncidenciaRepository repository;

    @Override
    public List<Incidencia> obtenerIncidencia() {
        return repository.findAll();
    }

    @Override
    public Incidencia verIDIncidencia(Integer idIncidencia) {
        return repository.findById(idIncidencia).orElse(null);
    }

    @Override
    public void guardarIncidencia(Incidencia incidencia) {
        repository.save(incidencia);

    }

    @Override
    public void actualizarIncidencia(Incidencia incidencia) {
        repository.saveAndFlush(incidencia);

    }

    @Override
    public void eliminarIncidencia(Integer idIncidencia) {
        repository.deleteById(idIncidencia);

    }
}
