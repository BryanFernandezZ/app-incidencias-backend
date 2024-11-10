package com.app.gestion.app.service;

import com.app.gestion.app.model.Cliente;
import com.app.gestion.app.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClienteServiceImp implements ClienteService{

    @Autowired
    private ClienteRepository repository;

    @Override
    public List<Cliente> obtenerCliente() {
        return repository.findAll();
    }

    @Override
    public Cliente verCliente(Integer idCliente) {
        return repository.findById(idCliente).orElse(null);
    }

    @Override
    public void actualizaCliente(Cliente cliente) {
        repository.saveAndFlush(cliente);

    }

    @Override
    public void guardarCliente(Cliente cliente) {
        repository.save(cliente);

    }

    @Override
    public void eliminarCliente(Integer idcliente) {
        repository.deleteById(idcliente);

    }



//    public Cliente verClientePorNombre(String nombre) {
//        return repository.findByNombre(nombre)
//                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
//    }


    public Cliente verClienteNombre(String nombre) {

        return repository.filtrarNombre(nombre).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }
}
