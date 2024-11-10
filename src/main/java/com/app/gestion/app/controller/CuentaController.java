package com.app.gestion.app.controller;

import com.app.gestion.app.model.Cuenta;
import com.app.gestion.app.service.CuentaService;
import com.google.common.base.Preconditions;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "CuentaController")
public class CuentaController {

    @Autowired
    private CuentaService service;

    @RequestMapping(path = "/app/cuentas",method = RequestMethod.GET)
    private List<Cuenta> listarCuentas(){
        return service.obtenerCuenta();
    }

    @RequestMapping(path = "/app/guardarcuenta",method = RequestMethod.POST)
    private void guardarCuenta(@RequestBody Cuenta cuenta){
        service.guardarCuenta(cuenta);
    }
    @RequestMapping(path = "/app/actualizarcuentaID",method=RequestMethod.PUT)
    private void actualizarCuenta(@RequestBody Cuenta cuenta){
        service.actualizarCuenta(cuenta);
    }

    @RequestMapping(path = "/app/eliminarcuenta/{id}",method = RequestMethod.DELETE)
    private void eliminarCuenta(@PathVariable("id") Integer idCuenta){
        Preconditions.checkArgument(idCuenta > 0, "El id debe ser mayor que cero");
        service.eliminar(idCuenta);
    }



}
