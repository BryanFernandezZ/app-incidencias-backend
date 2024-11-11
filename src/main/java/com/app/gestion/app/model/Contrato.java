package com.app.gestion.app.model;

import com.app.gestion.app.dto.ContratoRequestDto;
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
@Table(name = "contrato")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContrato;

    @Column(length = 100)
    private String ubicacionReferencial;

    @JsonIgnore
    @ManyToOne( fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @JsonIgnore
    @ManyToOne( fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_dispositivo")
    private Dispositivo dispositivo;

    @OneToMany(mappedBy = "contrato")
    private List<Incidencia> incidencia = new ArrayList<>();

    public Contrato(Integer idContrato) {
        this.idContrato = idContrato;
    }

}
