package com.app.gestion.app.service;


import com.app.gestion.app.model.Cuenta;

import java.util.List;

public interface CuentaService {
    List<Cuenta> obtenerCuenta();
    Cuenta verCuenta(Integer idcuenta);
    void guardarCuenta(Cuenta cuenta);
    void actualizarCuenta(Cuenta cuenta);
    void eliminar(Integer idcuenta);

}
