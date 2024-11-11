package com.app.gestion.app.service;

import com.app.gestion.app.model.Incidencia;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IncidenciaService {
    List<Incidencia> obtenerIncidencia();
    Incidencia verIDIncidencia(Integer idIncidencia);
    void guardarIncidencia(Incidencia incidencia, MultipartFile imagen);
    void actualizarIncidencia(Incidencia incidencia);
    void eliminarIncidencia(Integer idIncidencia);

}
