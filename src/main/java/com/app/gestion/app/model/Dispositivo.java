package com.app.gestion.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
        import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dispositivo")
public class Dispositivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDispositivo;

    @Column(length = 45)
    private String Nombre;

    @Column(length = 45)
    private String nombreCorto;

    @OneToMany(mappedBy = "dispositivo")
    private List<Contrato> contrato = new ArrayList<>();

}
