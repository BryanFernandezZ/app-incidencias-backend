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
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "cuenta")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCuenta;
    @Column(length = 45)
    private String nombreUsuario;
    @Column(length = 150)
    @JsonIgnore
    private String contrasena;

    @ManyToOne( fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_rol")
    private Rol rol;

    @OneToOne(mappedBy = "cuenta")
    private Usuario usuario;

    @OneToOne(mappedBy = "cuenta")
    private Cliente cliente;






}
