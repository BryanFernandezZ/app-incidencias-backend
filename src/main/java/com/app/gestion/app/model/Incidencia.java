package com.app.gestion.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "incidencia")
public class Incidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIncidencia;

    @Column(length = 254)
    private String detalle;

    @Column(length = 100)
    private String nomDispo;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String imagen;

    private Integer calificacion;
    private Boolean pendiente;
    private Boolean presencial;
    private Boolean solucionado;

    private Integer usuarioAsignado;

    @JsonIgnore
    @ManyToOne( fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @JsonIgnore
    @ManyToOne( fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}
