package com.vedruna.api_1_n.services;

import java.util.List;

import com.vedruna.api_1_n.dto.JugadorDTO;
import com.vedruna.api_1_n.persistance.models.Jugador;

public interface JugadorServiceI {
    
    List<JugadorDTO> getAllJugadores();
    List<JugadorDTO> getJugadorByNombreJugador(String nombreJugador);
    void inscribirJugador(Long jugadorId, Long equipoId);
    void insertarJugador(JugadorDTO jugador);
    void saveJugador(JugadorDTO jugador);
    void updateJugador(Long id, JugadorDTO jugador);
    void deleteJugador(Long id);
}
