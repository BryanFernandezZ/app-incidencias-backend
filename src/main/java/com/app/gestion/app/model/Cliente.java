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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    @Column(length = 45)
    private String nombre;
    @Column(length = 45)
    private String apellido;
    @Column(length = 100)
    private String direccion;
    @Column(length = 9)
    private String telefono;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "cuenta_id", referencedColumnName = "idCuenta")
    private Cuenta cuenta;


    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    private List<Incidencia> incidencias= new ArrayList<>();

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    private List<Contrato> contrato= new ArrayList<>();

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
}
