package com.app.gestion.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    @Column(length = 45)
    private String nombre;
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "cuenta_id", referencedColumnName = "idCuenta")
    private Cuenta cuenta;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<Incidencia> incidencias= new ArrayList<>();

}
