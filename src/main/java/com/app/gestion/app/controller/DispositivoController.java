package com.app.gestion.app.controller;

import com.app.gestion.app.service.DispositivoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DispositivoController {

    private final DispositivoService service;

    public DispositivoController(DispositivoService service) {
        this.service = service;
    }

    @RequestMapping(path = "/app/dispositivos/cliente/{id}", method = RequestMethod.GET)
    private ResponseEntity<?> obtenerDispositivosCliente(@PathVariable("id") Integer idCliente) {
        return ResponseEntity.ok(service.obtenerDispositivosCliente(idCliente));
    }
}
