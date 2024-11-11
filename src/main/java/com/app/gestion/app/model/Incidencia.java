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

    @Column(length = 70)
    private String asunto;

    @Column(length = 254)
    private String detalle;

    @Column(length = 1000)
    private String imagen;

    private Integer calificacion;
    private Boolean pendiente;
    private Boolean presencial;
    private Boolean solucionado;

    private Integer usuarioAsignado;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_contrato")
    private Contrato contrato;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;


    public Incidencia(String asunto, String detalle, Integer calificacion, Boolean pendiente, Boolean presencial, Boolean solucionado, Integer usuarioAsignado, Cliente cliente, Contrato contrato) {
        this.asunto = asunto;
        this.detalle = detalle;
        this.calificacion = calificacion;
        this.pendiente = pendiente;
        this.presencial = presencial;
        this.solucionado = solucionado;
        this.usuarioAsignado = usuarioAsignado;
        this.cliente = cliente;
        this.contrato = contrato;
    }
}
