package com.vedruna.api_1_n.persistance.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "equipos")
public class Equipo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idequipo", nullable = false)
    private Long equipoId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "equipo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Jugador> jugadores = new ArrayList<>();

    public void addJugador(Jugador jugador){
        if (jugador != null){
            jugadores.add(jugador);
            jugador.setEquipo(this);
        } else {
            System.out.println("jugador nulo");
        }
    }

}
