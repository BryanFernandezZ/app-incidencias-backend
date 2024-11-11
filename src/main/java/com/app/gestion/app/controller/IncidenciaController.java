package com.app.gestion.app.controller;

import com.app.gestion.app.dto.IncidenciaRequestDto;
import com.app.gestion.app.model.Incidencia;
import com.app.gestion.app.service.IncidenciaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@Tag(name = "IncidenciaController")
public class IncidenciaController {

    @Autowired
    private IncidenciaService service;

    @RequestMapping(path = "/app/ListarIncidencia",method = RequestMethod.GET)
    private List<Incidencia> listarIncidenicia(){
        return service.obtenerIncidencia();
    }

    @RequestMapping(path = "/app/guardarIndicenia", method = RequestMethod.POST)
    private void guardarIndicencia(
            @RequestParam("incidencia") String incidenciaJson,
            @RequestParam("imagen") MultipartFile imagen
    ) {
        ObjectMapper mapper = new ObjectMapper();
        IncidenciaRequestDto incidencia;
        try {
            incidencia = mapper.readValue(incidenciaJson, IncidenciaRequestDto.class);
            service.guardarIncidencia(incidencia.toEntidad(), imagen);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(path = "/app/actualizarIndicencia", method = RequestMethod.PUT)
    private void actualizarIndicenia(@RequestBody  Incidencia incidencia) {
        service.actualizarIncidencia(incidencia);
    }

    @RequestMapping(path = "/app/eliminarIndicencia/{id}",method =RequestMethod.DELETE)
    private void eliminarIndicenia(@PathVariable("id")Integer idIncidencia) {
        service.eliminarIncidencia(idIncidencia);
    }

}

