package com.vedruna.api_1_n.persistance.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "jugadores")
public class Jugador implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idjugador", nullable = false)
    private Long jugadorId;

    @Column(name = "nombre", nullable = false)
    private String nombreJugador;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @ManyToOne
    @JoinColumn(name = "equipos_idequipo", referencedColumnName = "idequipo", nullable = false)
    private Equipo equipo;
}