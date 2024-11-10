package com.app.gestion.app.service;

import com.app.gestion.app.model.Cuenta;
import com.app.gestion.app.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CuentaServiceImp implements CuentaService{

    @Autowired
    private CuentaRepository repository;
    @Override
    public List<Cuenta> obtenerCuenta() {
        return repository.findAll();
    }

    @Override
    public Cuenta verCuenta(Integer idcuenta) {
        return repository.findById(idcuenta).orElse(null);
    }

    @Override
    public void guardarCuenta(Cuenta cuenta) {
        repository.save(cuenta);

    }

    @Override
    public void actualizarCuenta(Cuenta cuenta) {
        repository.saveAndFlush(cuenta);

    }

    @Override
    public void eliminar(Integer idcuenta) {
        repository.deleteById(idcuenta);

    }
}
