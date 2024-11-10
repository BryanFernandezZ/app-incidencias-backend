package com.app.gestion.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contrato")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContrato;
    @Column(length = 100)
    private String NomDIspo;


    @JsonIgnore
    @ManyToOne( fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @JsonIgnore
    @ManyToOne( fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_dispositivo")
    private Dispositivo dispositivo;


}
