package com.app.gestion.app.controller;

import com.app.gestion.app.model.Contrato;
import com.app.gestion.app.service.ContratoService;
import com.google.common.base.Preconditions;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "ContratoController")
public class ContratoController {
    @Autowired
    private ContratoService service;

    @RequestMapping(path = "/app/listarContrato", method = RequestMethod.GET)
        private List<Contrato>listarContrato(){
        return service.obtenerContrato();
    }

    @RequestMapping(path = "/app/guardarContrato",method = RequestMethod.POST)
    private void guardarContrato(@RequestBody Contrato contrato){
        service.guardarContrato(contrato);
    }

    @RequestMapping(path = "/app/actualizarContrato",method = RequestMethod.PUT)
    private void actualizarContrato(@RequestBody Contrato contrato){
        service.actualizarContrato(contrato);
    }

    @RequestMapping(path = "/app/eliminarContrato/{id}", method = RequestMethod.DELETE)
    private void eliminarContrato(@PathVariable("id")Integer idContrato){
        Preconditions.checkArgument(idContrato > 0, "El id debe ser mayor que cero");
        service.eliminarContrato(idContrato);
    }


}
