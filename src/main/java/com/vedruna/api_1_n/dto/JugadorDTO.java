package com.vedruna.api_1_n.dto;

import com.vedruna.api_1_n.persistance.models.Jugador;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JugadorDTO {
    
    private Long jugadorId;
    private String nombreJugador;
    private Integer edad;
    private Long equipos_idequipo;

    public JugadorDTO(Jugador jugador){
        this.jugadorId = jugador.getJugadorId();
        this.nombreJugador = jugador.getNombreJugador();
        this.edad = jugador.getEdad();
        this.equipos_idequipo = jugador.getEquipo().getEquipoId();
    }
}
