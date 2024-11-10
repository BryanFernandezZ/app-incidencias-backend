package com.app.gestion.app.service;

import com.app.gestion.app.model.Cliente;

import java.util.List;

public interface ClienteService  {
    List<Cliente> obtenerCliente();
    Cliente verCliente(Integer idCliente);
    void actualizaCliente(Cliente cliente);
    void guardarCliente(Cliente cliente);
    void eliminarCliente(Integer idcliente);
    Cliente verClienteNombre(String nombre);
//Cliente verClientePorNombre(String nombre);

}
