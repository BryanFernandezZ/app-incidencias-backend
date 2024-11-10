package com.app.gestion.app.controller;

import com.app.gestion.app.model.Cliente;
import com.app.gestion.app.service.ClienteService;
import com.google.common.base.Preconditions;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "ClienteController")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @RequestMapping(path = "/app/cliente", method = RequestMethod.GET)
    private List<Cliente> listarCliente() {
        return service.obtenerCliente();
    }

    @RequestMapping(path = "/app/guardarCliente", method = RequestMethod.POST)
    private void guardarCliente(@RequestBody Cliente cliente) {
        service.guardarCliente(cliente);
    }

    @RequestMapping(path = "/app/actualizarCliente", method = RequestMethod.PUT)
    private void actualizarCliente(@RequestBody Cliente cliente) {
        service.actualizaCliente(cliente);
    }

    @RequestMapping(path = "/app/eliminarCliente/{id}", method = RequestMethod.DELETE)
    private void eliminarCliente(@PathVariable("id") Integer idCliente) {
        Preconditions.checkArgument(idCliente > 0, "El id debe ser mayor que cero");
        service.eliminarCliente(idCliente);
    }

    @RequestMapping(path = "/app/buscarCliente/{id}", method = RequestMethod.GET)
    private ResponseEntity<?> buscarClietne(@PathVariable Integer id) {
        Preconditions.checkArgument(id > 0, "El id debe ser mayor que cero");
        Cliente cliente = service.verCliente(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @RequestMapping(path = "/app/buscarClienteNom/{nombre}", method = RequestMethod.GET)
    private ResponseEntity<?> buscarClienteNombre(@PathVariable String nombre) {
        Cliente cliente = service.verClienteNombre(nombre);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

}
