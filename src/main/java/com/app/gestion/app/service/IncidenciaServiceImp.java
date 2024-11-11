package com.app.gestion.app.service;

import com.app.gestion.app.model.Incidencia;
import com.app.gestion.app.repository.IncidenciaRepository;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.google.common.base.Joiner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class IncidenciaServiceImp implements IncidenciaService {

    @Autowired
    private IncidenciaRepository repository;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<Incidencia> obtenerIncidencia() {
        return repository.findAll();
    }

    @Override
    public Incidencia verIDIncidencia(Integer idIncidencia) {
        return repository.findById(idIncidencia).orElse(null);
    }

    @Override
    public void guardarIncidencia(Incidencia incidencia, MultipartFile image) {
        Joiner joiner = Joiner.on("_").skipNulls();
        String imageName = joiner.join(incidencia.getIdIncidencia(), image.getOriginalFilename());
        try {
            //  GUARDAMOS LA IMAGEN A CLOUD STOREGE
            Map<String, Object> uploadResult = cloudinary.uploader().upload(
                    image.getBytes(), ObjectUtils.asMap("public_id", imageName)
            );
            String imageUrl = (String) uploadResult.get("secure_url");
            incidencia.setImagen(imageUrl);
            repository.save(incidencia);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void actualizarIncidencia(Incidencia incidencia) {
        repository.saveAndFlush(incidencia);

    }

    @Override
    public void eliminarIncidencia(Integer idIncidencia) {
        repository.deleteById(idIncidencia);

    }
}
